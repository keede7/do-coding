package hello.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "hello.config.autoconfig.DispatcherServletConfig",
                "hello.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
