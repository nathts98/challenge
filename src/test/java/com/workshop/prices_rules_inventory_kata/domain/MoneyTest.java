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

    @Test
    void should_return_not_equal_if_currency_is_different(){
        Currency dollar = Currency.getInstance("USD");
        Assertions.assertNotEquals(Money.of("10", euro), Money.of("10", dollar));
    }

    @Test
    void should_return_new_money_vo_with_sum_result_when_add_method_called(){
        Money some = Money.of("10", euro);
        Money sum = some.add(Money.of("2.5", euro));
        Money result = Money.of("12.5", euro);

        Assertions.assertEquals(sum, result);
    }

    @Test
    void should_not_add_money_if_different_currency(){
        Currency dollar = Currency.getInstance("USD");
        Money some = Money.of("10", euro);

        Assertions.assertThrows(InvalidMoneyException.class, ()-> some.add(Money.of("2.5", dollar)));
    }

    @Test
    void should_return_new_vo_when_subtract_method_called(){
        Money some = Money.of("10", euro);
        Money sum = some.subtract(Money.of("2.5", euro));
        Money result = Money.of("7.5", euro);

        Assertions.assertEquals(sum, result);
    }

}
