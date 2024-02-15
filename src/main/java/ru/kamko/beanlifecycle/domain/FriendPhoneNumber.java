package ru.kamko.beanlifecycle.domain;

/**
 * Не является компонентом, этот класс будем использовать для подмены оригинальной логики
 */
public class FriendPhoneNumber extends PhoneNumber {

    @Override
    public String getOwnerNumber() {
        return "some friend";
    }
}
