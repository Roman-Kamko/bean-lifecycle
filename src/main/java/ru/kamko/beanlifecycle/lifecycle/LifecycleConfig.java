package ru.kamko.beanlifecycle.lifecycle;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(CustomBeanDefinitionRegister.class)
@Configuration
@ConditionalOnProperty(name = "lifecycle.print.original", havingValue = "false")
public class LifecycleConfig {
}
