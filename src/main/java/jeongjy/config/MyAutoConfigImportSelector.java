package jeongjy.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "jeongjy.config.autoconfig.DispatcherServletConfig",
                "jeongjy.config.autoconfig.TomcatWebServerConfig",
        };
    }
}
