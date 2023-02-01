package hello.tobyspring;

import java.util.Objects;

public class HelloController {
    public String hello(String name) {
        SimpleHelloService helloHelloService = new SimpleHelloService();
        // null이면 예외발생, 아니라면 그대로 사용하여 return
        return helloHelloService.sayHello(Objects.requireNonNull(name));
    }
}
