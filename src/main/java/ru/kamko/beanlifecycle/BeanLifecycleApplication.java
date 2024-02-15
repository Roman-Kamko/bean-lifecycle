package ru.kamko.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kamko.beanlifecycle.domain.Phone;

@SpringBootApplication
public class BeanLifecycleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BeanLifecycleApplication.class, args);
        try {
            Phone phone = context.getBean(Phone.class);
            phone.callPhoneNumber();
        } catch (Exception e) {
            System.out.println("Ooops");
        }
    }

}
