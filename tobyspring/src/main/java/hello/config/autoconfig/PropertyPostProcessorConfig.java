package hello.config.autoconfig;

import hello.config.MyAutoConfiguration;
import hello.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor postProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                // 마커 애노테이션을 달고있는 클래스에 적용하려고한다.
                MyConfigurationProperties annotation = findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if(annotation == null){
                    return bean;
                }

                // prefix에 대한 정보를 가져와야한다.
                Map<String, Object> annotationAttributes = AnnotationUtils.getAnnotationAttributes(annotation);

                String prefix = (String) annotationAttributes.get("prefix");

                return Binder
                        .get(env)
                        .bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
