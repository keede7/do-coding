package hello.tobyspring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
// 빈의 우선순위를 지정하는 방법
// 빈이 2개 이상이면 이 클래스가 가장 우선으로 주입된다.
@Primary
public class HelloDecorator implements HelloService {
    // 구현클래스이면서 HelloService를 구현한 클래스를 의존하는 클래스가 되어야 한다.
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
