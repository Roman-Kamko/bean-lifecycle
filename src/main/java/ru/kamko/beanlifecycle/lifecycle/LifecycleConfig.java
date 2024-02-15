package ru.kamko.beanlifecycle.lifecycle;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(CustomBeanDefinitionRegister.class)
@Configuration
public class LifecycleConfig {
}
