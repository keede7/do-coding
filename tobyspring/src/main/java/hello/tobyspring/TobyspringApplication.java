package hello.tobyspring;

import hello.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * 스프링 부트가 없이 설정해본다.
 */
// 빈 팩토리를 가진 클래스임을 알려주기 위해 @Configuration 을 붙여준다.
@MySpringBootApplication
public class TobyspringApplication {
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
