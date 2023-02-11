package hello.config;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE}) // 클래스, 인터페이스, Enum
@Component
public @interface MyConfigurationProperties {
    String prefix();
}
