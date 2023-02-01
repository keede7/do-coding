package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 스프링 부트가 없이 설정해본다.
 */
public class TobyspringApplication {

    public static void main(String[] args) {
        System.out.println("Hello Containerless Standalone");
        // Application Context == Spring Container
        // 어셈블러를 가져오고
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
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
        // 각 빈들을 등록시킨다.
        applicationContext.registerBean(HelloController.class);
        // 등록할 때 구체적은 클래스 타입을 넣어줘야 하기 때문에 인터페이스가 아닌 구현체를 넣는다.
        applicationContext.registerBean(SimpleHelloService.class);
        // 처음에 가지고있는 구성정보를 초기화한다.
        applicationContext.refresh();

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
