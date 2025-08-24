package com.workshop.prices_rules_inventory_kata.domain;

import com.workshop.prices_rules_inventory_kata.domain.exceptions.InvalidMoneyException;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    static Money of(String amount) {
        try {
            BigDecimal parsedAndNormalized = new BigDecimal(amount);
            if(parsedAndNormalized.compareTo(BigDecimal.ZERO) < 0){
                throw new InvalidMoneyException("Amount must be >= 0");
            }
            return new Money(parsedAndNormalized);
        } catch (NumberFormatException e){
            throw new InvalidMoneyException("Amount must be numeric");
        }
    }
}
