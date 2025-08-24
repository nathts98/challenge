package com.workshop.prices_rules_inventory_kata.domain;


import com.workshop.prices_rules_inventory_kata.domain.exceptions.InvalidMoneyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Currency;


public class MoneyTest {
    Currency euro = Currency.getInstance("EUR");

    @Test
    void should_create_money_object(){
        Money money = Money.of("10.00", euro);
        Assertions.assertNotNull(money);
        Assertions.assertInstanceOf(Money.class, money);
    }

    @Test
    void should_throw_invalid_money_exception_if_negative(){
        Assertions.assertThrows(InvalidMoneyException.class, () -> Money.of("-5.0", euro));
    }

    @Test
    void should_throw_invalid_money_exception_if_letters(){
        Assertions.assertThrows(InvalidMoneyException.class, () -> Money.of("abc", euro));
    }

    @Test
    void should_return_true_when_comparing_empty_decimals(){
        Assertions.assertEquals(Money.of("10", euro), Money.of("10.00", euro));
    }

}
