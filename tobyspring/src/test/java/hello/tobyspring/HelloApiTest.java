package hello.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {

    @Test
    void helloApi() {
        // RestTemplate을 쓰면 외부 API를 호출할 수 있다.
        // 만약 400,500 이 발생하면 예외를 발생시킨다.
        TestRestTemplate rest = new TestRestTemplate();

        // 치환자를 통해서 동적으로 QueryString 을 입력할 수 있도록 변경
        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:9090/hello?name={name}", String.class, "Spring");

        /**
         * 검증 과정
         * 1. 상태코드,
         * 2. 헤더
         * 3. 바디 값
         */
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }


    @Test
    void failHelloApi() {
        // RestTemplate을 쓰면 외부 API를 호출할 수 있다.
        // 만약 400,500 이 발생하면 예외를 발생시킨다.
        TestRestTemplate rest = new TestRestTemplate();

        // 치환자를 통해서 동적으로 QueryString 을 입력할 수 있도록 변경
        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:9090/hello?name=", String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
