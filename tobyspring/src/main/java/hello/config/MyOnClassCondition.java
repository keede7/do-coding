package hello.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

// 관례를 이용한 방식이라서 눈에 확 띄지는 않는다.
//프로퍼티를 사용한 방식도 있지만 이게 통상적이다.
public class MyOnClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 메타데이터에서 내가 사용할 애노테이션을 끌어와야한다,.
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
        String value = (String)annotationAttributes.get("value");

        return ClassUtils.isPresent(value, context.getClassLoader());
    }
}
