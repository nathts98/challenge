package com.workshop.prices_rules_inventory_kata.domain;

import com.workshop.prices_rules_inventory_kata.domain.exceptions.InvalidMoneyException;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@EqualsAndHashCode
public class Money {
    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    static Money of(String amount, Currency currency) {
        try {
            BigDecimal parsedAndNormalized = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);

            if(parsedAndNormalized.compareTo(BigDecimal.ZERO) < 0){
                throw new InvalidMoneyException("Amount must be >= 0");
            }

            return new Money(parsedAndNormalized);
        } catch (NumberFormatException e){
            throw new InvalidMoneyException("Amount must be numeric");
        }
    }
}
