package ru.kamko.beanlifecycle.domain;

import org.springframework.stereotype.Component;

/**
 * Компонент и единственный наследник {@link PhoneNumber}, используется в базовой логике
 */
@Component
public class GirlfriendPhone extends PhoneNumber {

    @Override
    public String getOwnerNumber() {
        return "some girlfriend";
    }
}
