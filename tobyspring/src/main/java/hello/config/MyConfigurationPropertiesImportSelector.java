package hello.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

public class MyConfigurationPropertiesImportSelector
implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());

        Class value = (Class) allAnnotationAttributes.getFirst("value");

        return new String[] {value.getName()};
    }
}
