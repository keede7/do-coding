package hello.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 스프링 부트가 없이 설정해본다.
 */
// 빈 팩토리를 가진 클래스임을 알려주기 위해 @Configuration 을 붙여준다.
@Configuration
@ComponentScan // Component가 붙은 클래스를 찾아 빈으로 등록해달라.
public class TobyspringApplication {

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
    }

}
