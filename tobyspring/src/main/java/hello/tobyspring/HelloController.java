package hello.tobyspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello") // RequestMapping 이 필요없음.
    public String hello(String name) {
        // null이면 예외발생, 아니라면 그대로 사용하여 return
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
