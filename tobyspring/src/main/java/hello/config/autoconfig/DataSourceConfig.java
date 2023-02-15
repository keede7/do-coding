package hello.config.autoconfig;

import com.zaxxer.hikari.HikariDataSource;
import hello.config.ConditionalMyOnClass;
import hello.config.EnableMyConfigurationProperties;
import hello.config.MyAutoConfiguration;
import hello.config.MyConfigurationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;

@MyAutoConfiguration
// JdbcOperations 인터페이스의 경로를 넣는다.
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
// AOP 관련된 기능을 넣기위해 추가
@EnableTransactionManagement
public class DataSourceConfig {

    /**
     * 두 개의 Datasource를 만들었기 때문에 설정을 추가로 줘야한다.
     */

    // 외부 프로퍼티 파일로부터 주입받아 사용하는 방식으로해본다.
    @Bean
    // 같은타입으로 다른 빈이 없으면 기본으로 적용한다,
    @ConditionalOnMissingBean
    public DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    public DataSource hikariDataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }


    @Bean
    // 해당 메서드가 실행될때 DataSource타입의 빈이 하나만 가지고 있다면
    //그 데이터소스를 가져와서 사용한다.
    @ConditionalOnSingleCandidate(DataSource.class)
    @ConditionalOnMissingBean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    // 해당 메서드가 실행될때 DataSource타입의 빈이 하나만 가지고 있다면
    //그 데이터소스를 가져와서 사용한다.
    @ConditionalOnSingleCandidate(DataSource.class)
    @ConditionalOnMissingBean
    JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
        JdbcTransactionManager jdbcTransactionManager = new JdbcTransactionManager();
        jdbcTransactionManager.setDataSource(dataSource);
        return jdbcTransactionManager;
    }
}
