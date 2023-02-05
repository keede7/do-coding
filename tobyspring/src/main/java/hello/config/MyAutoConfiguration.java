package hello.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE}) // 클래스, 인터페이스, Enum
//proxyBeanMethods = false  => 해당 애노테이션으로 등록한 이하의 Bean 객체들은 프록시 클래스로 생성되지 않는다.
@Configuration(proxyBeanMethods = false)
// 자동 구성방식에 사용할 목록을 집어넣어 사용할 것.
public @interface MyAutoConfiguration {
}
