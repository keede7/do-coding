package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

    /*
        순수하게 이 상태에서 서버를 실행할 경우에
        해당 패키지는 ComponentScan으로 인해 Bean으로 등록되고
        자동구성정보로 등록해둔 Bean과 겹치기 떄문에 에러가 발생하게 될것이다.
     */
    @Bean
    public ServletWebServerFactory customWebServerFactory() {
        TomcatServletWebServerFactory tomcatWebServerConfig = new TomcatServletWebServerFactory();
        tomcatWebServerConfig.setPort(9090);

        return tomcatWebServerConfig;
    }

}
