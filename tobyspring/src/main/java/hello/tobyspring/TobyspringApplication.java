package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

/**
 * 스프링 부트가 없이 설정해본다.
 */
public class TobyspringApplication {

    public static void main(String[] args) {
        System.out.println("Hello Containerless Standalone");
        /**
         * 서블릿 컨테이너 생성하기.
         * 스프링 부트가 톰캣서블릿 컨테이너를 내장해서 코드로 쉽게 시작해 사용하도록 만든 클래스가 있다.
         * TomcatServletWebServerFactory();
         */
        ServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        // 서블릿컨테이너를 만드는 함수.
        WebServer webServer = tomcatServletWebServerFactory.getWebServer();
        // 톰캣 서블릿 컨테이너 동작.
        webServer.start();

    }

}
