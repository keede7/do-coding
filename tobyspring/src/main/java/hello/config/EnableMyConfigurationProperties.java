package hello.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// EnableXXX 활용용도는 Import 애노테이션을 더 넣어서
// 어떤 기능을가진 설정정보를 가져오게 하는 게 목적
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE}) // 클래스, 인터페이스, Enum
@Import(MyConfigurationPropertiesImportSelector.class)
public @interface EnableMyConfigurationProperties {
    Class<?> value();
}
