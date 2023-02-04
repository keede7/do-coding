package hello.tobyspring;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class MySpringApplication {

    public static void run(Class<?> applicationClass, String[] args) {
        System.out.println("Hello Containerless Standalone");
        // Application Context == Spring Container
        // 어셈블러를 가져오고
        // GenericWebApplicationContext는 자바코드로 만든 Config를 읽어올수 없다.
        // 따라서 타입을 변경해줘야한다. AnnotationConfigWebApplicationContext
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory tomcatServletWebServerFactory = this.getBean(ServletWebServerFactory.class);
                // 컨테이너를 통해서 DispatcherServlet도 가져온다.
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                // 서블릿컨테이너를 만드는 함수.
                WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
                    // 디스패처 서블릿으로 변환한다.
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*");
                });
                // 톰캣 서블릿 컨테이너 동작.
                webServer.start();
            }
        };

        // 자바코드로 구성정보를 가진 클래스를 등록해줘야한다.
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
