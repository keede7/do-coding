package hello.config;

import hello.config.autoconfig.DispatcherServletConfig;
import hello.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE}) // 클래스, 인터페이스, Enum
// @Import도 애노테이션의 메타 애노테이션으로 쓸 수 있다.
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})
public @interface EnableMyAutoConfiguration {
}
