package ru.kamko.beanlifecycle.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.kamko.beanlifecycle.domain.Phone;

import java.lang.reflect.Field;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    private static final String PROPERTY = "greeting";

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(Phone.class)) {
            updateGreeting(bean);
        }

        return bean;
    }

    /**
     * Подменим значение поля {@code greeting} в классе {@link Phone}
     * @param bean
     */
    private void updateGreeting(Object bean) {
        Class<Phone> aClass = Phone.class;
        try {
            Field field = aClass.getDeclaredField(PROPERTY);
            field.setAccessible(true);
            field.set(bean, "another greeting");
            System.out.println(field.get(bean));
        } catch (Exception e) {
            throw new InvalidPropertyException(Phone.class, PROPERTY,
                    "Bean class does not have expected property", e);
        }
    }
}
