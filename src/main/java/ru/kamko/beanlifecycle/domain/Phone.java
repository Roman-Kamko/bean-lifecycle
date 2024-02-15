package ru.kamko.beanlifecycle.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "lifecycle.print.enabled", havingValue = "false")
public class Phone {

    private String greeting = "original greeting";
    private final PhoneNumber phoneNumber;

    public void callPhoneNumber() {
        System.out.println(phoneNumber.getOwnerNumber() + " " + greeting);
    }

}
