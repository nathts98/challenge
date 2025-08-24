package com.workshop.prices_rules_inventory_kata.domain;


import com.workshop.prices_rules_inventory_kata.domain.exceptions.InvalidMoneyException;
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

    @Test
    void should_throw_invalid_money_exception_if_letters(){
        Assertions.assertThrows(InvalidMoneyException.class, () -> Money.of("abc"));
    }

    @Test
    void should_return_true_when_comparing_empty_decimals(){
        Assertions.assertEquals(Money.of("10"), Money.of("10.00"));
    }

}
