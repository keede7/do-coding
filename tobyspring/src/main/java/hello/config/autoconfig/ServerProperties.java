package hello.config.autoconfig;

import hello.config.MyConfigurationProperties;
import org.springframework.beans.factory.annotation.Value;



@MyConfigurationProperties(prefix = "server")
public class ServerProperties {
    // 환경변수에 값을 할당시킬수있다.
    @Value("${contextPath:}")
    private String contextPath;

    // 만약 ${port}의 프로퍼티에 값이없다면
    // 디폴트값을 넣어줄수 있다 .
    // ${port:디폴트값}
    @Value("${port:8080}")
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
