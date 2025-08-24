package com.workshop.prices_rules_inventory_kata.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MoneyTest {

    @Test
    void should_create_money_object(){
        Money money = Money.of("10.00");
        Assertions.assertNotNull(money);
        Assertions.assertInstanceOf(Money.class, money);
    }

    @Test
    void should_throw_invalid_money_exception_if_negative(){
        Assertions.assertThrows(InvalidMoneyException.class, () -> Money.of("-5.0"));
    }
}
