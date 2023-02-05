package hello.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyAutoConfigurationSelector implements DeferredImportSelector {

    // 클래스로더를 직접 구현해서 사용할 수 있고, 주입받아 쓸수도 있다.
    private final ClassLoader classLoader;

    public MyAutoConfigurationSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        List<String> autoConfigs = new ArrayList<>();

        ImportCandidates.load(MyAutoConfiguration.class, classLoader)
                .forEach(autoConfigs::add);

        return autoConfigs.toArray(new String[0]);
    }
}
