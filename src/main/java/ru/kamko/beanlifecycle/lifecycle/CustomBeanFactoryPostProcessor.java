package ru.kamko.beanlifecycle.lifecycle;

import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import ru.kamko.beanlifecycle.domain.FriendPhoneNumber;
import ru.kamko.beanlifecycle.domain.GirlfriendPhone;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // Найдем бин GirlfriendPhone и подменим его на FriendPhoneNumber, тем самым изменив оригинальную логику
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

            if (GirlfriendPhone.class.getName().equalsIgnoreCase(beanDefinition.getBeanClassName())) {
                beanDefinition.setBeanClassName(FriendPhoneNumber.class.getName());
                ((ScannedGenericBeanDefinition) beanDefinition).addMetadataAttribute(
                        new BeanMetadataAttribute("className", FriendPhoneNumber.class.getName())
                );
                beanDefinition.setAutowireCandidate(true);
            }
        }
    }
}
