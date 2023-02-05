package hello.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE}) // 클래스, 인터페이스, Enum
@Configuration
// 자동 구성방식에 사용할 목록을 집어넣어 사용할 것.
public @interface MyAutoConfiguration {
}
