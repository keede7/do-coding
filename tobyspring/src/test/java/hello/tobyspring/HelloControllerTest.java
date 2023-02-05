package hello.tobyspring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloControllerTest {

    @Test
    void helloController() {
        // 여기서 벌써 의존성이 필요해지기 떄문에 에러가 발생한다.
        // 가장 쉬운방법은 그냥 구현을 만들어서 넣는것이다.
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");
        assertThat(ret).isEqualTo("Test");
        // 위 테스트를 만든 이유..
        // API 호출하는 웹컴포넌트가 항상 완벽하게 동작한다 생각하면 안된다.
        // null이 들어오는 경우 막는 로직을 만들었지만 진짜로 예외를 막는지에 대한 테스트가 필요해진다.

    }

    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);

//        // 예외가 발생!!
//        String hello = helloController.hello(null);

        assertThatThrownBy(() -> helloController.hello(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> helloController.hello(""))
                .isInstanceOf(IllegalArgumentException.class);

    }

}