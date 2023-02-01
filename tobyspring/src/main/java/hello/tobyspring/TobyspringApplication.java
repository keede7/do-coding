package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
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
        // Application Context == Spring Container
        // 어셈블러를 가져오고
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        // 각 빈들을 등록시킨다.
        genericApplicationContext.registerBean(HelloController.class);
        // 등록할 때 구체적은 클래스 타입을 넣어줘야 하기 때문에 인터페이스가 아닌 구현체를 넣는다.
        genericApplicationContext.registerBean(SimpleHelloService.class);
        // 처음에 가지고있는 구성정보를 초기화한다.
        genericApplicationContext.refresh();

        /**
         * 서블릿 컨테이너 생성하기.
         * 스프링 부트가 톰캣서블릿 컨테이너를 내장해서 코드로 쉽게 시작해 사용하도록 만든 클래스가 있다.
         * TomcatServletWebServerFactory();
         */
        ServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        // 서블릿컨테이너를 만드는 함수.
        WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {

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

                        HelloController helloController = genericApplicationContext.getBean(HelloController.class);
                        String ret = helloController.hello(name);

                        // 일반적으로 성공하면 200을 전달한다.
//                        resp.setStatus(HttpStatus.OK.value());
                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
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
