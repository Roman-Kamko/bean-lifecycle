package ru.kamko.beanlifecycle.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

public class CustomBeanDefinitionRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        registerBeanDefinitions(importingClassMetadata, registry);
    }

    /**
     * Зарегистрируем кастомные BFPP и BPP
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        registerBeanFactoryPostProcessor(registry);
        registerBeanPostProcessor(registry);
    }

    private void registerBeanFactoryPostProcessor(BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(CustomBeanFactoryPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("customBeanFactoryPostProcessor", genericBeanDefinition);
    }

    private void registerBeanPostProcessor(BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(CustomBeanPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("customBeanPostProcessor", genericBeanDefinition);
    }
}
