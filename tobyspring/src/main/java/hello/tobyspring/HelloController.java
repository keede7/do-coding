package hello.tobyspring;

import org.springframework.web.bind.annotation.GetMapping;
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
        // null, empty 체크
        if(name == null || name.length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }
}
