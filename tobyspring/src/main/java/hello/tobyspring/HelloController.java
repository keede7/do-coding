package hello.tobyspring;

import java.util.Objects;

public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        // null이면 예외발생, 아니라면 그대로 사용하여 return
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
