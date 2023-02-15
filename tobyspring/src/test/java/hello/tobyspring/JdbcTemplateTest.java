package hello.tobyspring;

import hello.HellobootTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        // 테이블을 생성하는 코드.
        jdbcTemplate.execute(
                "create table if " +
                        "not exists hello(name varchar(50) primary key, count int) "
        );
    }

    @Test
    void insertAndQuery() {

        jdbcTemplate.update(
                "insert into hello values(?,?)", "Toby1",1
        );
        jdbcTemplate.update(
                "insert into hello values(?,?)", "Toby2",2
        );

        Long aLong = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(aLong).isEqualTo(2);
    }


}
