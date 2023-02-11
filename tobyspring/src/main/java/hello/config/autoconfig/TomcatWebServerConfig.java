package hello.config.autoconfig;

import hello.config.ConditionalMyOnClass;
import hello.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
// 톰캣과 관련된 클래스가 존재하면 톰캣서버를 띄운다.
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    // Conditional은 Method레벨에도 등록할 수 있다.
    // 이미 등록된 동일한 타입이 존재하는지 보고
    // 존재하지 않는다면 이 Bean을 등록해줘라 라고 하는것.
    // 이 Conditional 판단 시점에는 유저구성정보(비즈니스 로직 빈들)이 이미 등록된 상태이다.
    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
