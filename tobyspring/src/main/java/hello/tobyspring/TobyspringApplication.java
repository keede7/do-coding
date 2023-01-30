package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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
        /**
         * 서블릿 컨테이너 생성하기.
         * 스프링 부트가 톰캣서블릿 컨테이너를 내장해서 코드로 쉽게 시작해 사용하도록 만든 클래스가 있다.
         * TomcatServletWebServerFactory();
         */
        ServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        // 서블릿컨테이너를 만드는 함수.
        WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();

            // 모든 요청을 받고 위임처리 역할을 하는 front Controller 로 변경된다.
            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능

                    String requestURI = req.getRequestURI();
                    String method = req.getMethod();

                    if (requestURI.equals("/hello") && method.equals(HttpMethod.GET.name())) {
                        // 요청을 받아 동적으로 url을 변경
                        String name = req.getParameter("name");

                        String ret = helloController.hello(name);

                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    } else if (requestURI.equals("/user")) {

                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
                // 해당 프론트 컨트롤러는 모든 요청을 처리한다.
            }).addMapping("/*");
        });
        // 톰캣 서블릿 컨테이너 동작.
        webServer.start();
    }

}
