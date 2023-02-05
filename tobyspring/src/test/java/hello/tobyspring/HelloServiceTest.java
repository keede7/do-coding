package hello.tobyspring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }

}