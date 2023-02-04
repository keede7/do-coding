package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 스프링 부트가 없이 설정해본다.
 */
// 빈 팩토리를 가진 클래스임을 알려주기 위해 @Configuration 을 붙여준다.
@Configuration
public class TobyspringApplication {
    // 팩토리 메서드를 사용해서 오브젝트를 만들고 빈으로 등록한다.
    // 이메서드는 컨테이너가 호출할건데,
    // 내가 필요한 파라미터를 넘겨줘라.
    // Bean 정보임을 알려줘야하기 떄문에 @Bean을 붙여준다.
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    // 구현체로 타입을 설정하지말고 인터페이스 타입으로 설정할 것.
    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
        System.out.println("Hello Containerless Standalone");
        // Application Context == Spring Container
        // 어셈블러를 가져오고
        // GenericWebApplicationContext는 자바코드로 만든 Config를 읽어올수 없다.
        // 따라서 타입을 변경해줘야한다. AnnotationConfigWebApplicationContext
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
                // 서블릿컨테이너를 만드는 함수.
                WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
                    // 디스패처 서블릿으로 변환한다.
                    servletContext.addServlet("dispatcherServlet",
                            // 자기자신인 ApplicationContext를 넣어준다.
                            new DispatcherServlet(this)
                    ).addMapping("/*");
                });
                // 톰캣 서블릿 컨테이너 동작.
                webServer.start();
            }
        };

        // 자바코드로 구성정보를 가진 클래스를 등록해줘야한다.
        applicationContext.register(TobyspringApplication.class);
        applicationContext.refresh();

//        // 각 빈들을 등록시킨다.
//        applicationContext.registerBean(HelloController.class);
//        // 등록할 때 구체적은 클래스 타입을 넣어줘야 하기 때문에 인터페이스가 아닌 구현체를 넣는다.
//        applicationContext.registerBean(SimpleHelloService.class);
//        // 처음에 가지고있는 구성정보를 초기화한다.
//        applicationContext.refresh();

        /**
         * 서블릿 컨테이너 생성하기.
         * 스프링 부트가 톰캣서블릿 컨테이너를 내장해서 코드로 쉽게 시작해 사용하도록 만든 클래스가 있다.
         * TomcatServletWebServerFactory();
         */
//        ServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        // 서블릿컨테이너를 만드는 함수.
//        WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
//            // 디스패처 서블릿으로 변환한다.
//            servletContext.addServlet("dispatcherServlet",
//                    new DispatcherServlet(applicationContext)
//            ).addMapping("/*");
//        });
//        // 톰캣 서블릿 컨테이너 동작.
//        webServer.start();
    }

}
