package hello.tobyspring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;


/**
 * @Conditional 적용 테스트를 해본다.
 */
public class ConditionalTest {

    @Test
    void conditional() {
        // true
        // AssertJ에서 제공하는 테스트 전용 컨텍스트를 생성해서 해본다.
        ApplicationContextRunner contextRunner1 = new ApplicationContextRunner();
        contextRunner1.withUserConfiguration(Config1.class)
                .run(context -> {
                    Assertions.assertThat(context).hasSingleBean(MyBean.class);
                    Assertions.assertThat(context).hasSingleBean(Config1.class);
                });

        // false
        new ApplicationContextRunner().withUserConfiguration(Config2.class)
                .run(context -> {
                    Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
                    Assertions.assertThat(context).doesNotHaveBean(Config2.class);
                });
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(value = TrueCondition.class)
    @interface TrueConditional {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(value = FalseCondition.class)
    @interface FalseConditional {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(value = BooleanCondition.class)
    @interface BooleanConditional {
        // 속성을 추가한다.
        // 만약 하나만 가질경우에는 애노테이션 속성을 작성하지않아도 된다.
        boolean value();
    }

    static class BooleanCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context,
                               AnnotatedTypeMetadata metadata) {
            //AnnotatedTypeMetadata 를 통해서 속성에 지정한 값들을 읽어올수있다.
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
            Boolean value = (Boolean) annotationAttributes.get("value");
            return value;
        }
    }

    @Configuration
    @BooleanConditional(true)
    static class Config1 {
        @Bean
        MyBean mybean() {
            return new MyBean();
        }
    }

    @Configuration
    @BooleanConditional(false)
    static class Config2 {
        @Bean
        MyBean mybean() {
            return new MyBean();
        }
    }

    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context,
                               AnnotatedTypeMetadata metadata) {
            return true;
        }
    }

    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context,
                               AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

}
