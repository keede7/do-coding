package hello.tobyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 스프링 부트가 없이 설정해본다.
 */
// 빈 팩토리를 가진 클래스임을 알려주기 위해 @Configuration 을 붙여준다.
@Configuration
@ComponentScan // Component가 붙은 클래스를 찾아 빈으로 등록해달라.
public class TobyspringApplication {

    // 해당 코드가 없으면 서버를 실행할 수 없다.
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    /**
     * 여태 해온 작업이 스프링부트가 서버를 동작시키는 원리였다.
     * @param args
     */
    public static void main(String[] args) {
//        MySpringApplication.run(TobyspringApplication.class, args);
        // 위의 Config 코드를 제외하면 동일하다.
        SpringApplication.run(TobyspringApplication.class, args);
    }

}
