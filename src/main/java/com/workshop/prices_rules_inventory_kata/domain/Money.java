package com.workshop.prices_rules_inventory_kata.domain;

import com.workshop.prices_rules_inventory_kata.domain.exceptions.InvalidMoneyException;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@EqualsAndHashCode
public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    private Money(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
    }

    static Money of(String amount, Currency currency) {
        try {
            BigDecimal parsed = new BigDecimal(amount);

            if(parsed.compareTo(BigDecimal.ZERO) < 0){
                throw new InvalidMoneyException("Amount must be >= 0");
            }

            return new Money(parsed, currency);
        } catch (NumberFormatException e){
            throw new InvalidMoneyException("Amount must be numeric");
        }
    }

    public Money add(Money other) {
        if (!other.currency.equals(this.currency)) {
            throw new InvalidMoneyException("Currency must match to add money");
        }
        BigDecimal sum = this.amount.add(other.amount);
        return new Money(sum, this.currency);
    }

    public Money subtract(Money other) {
        BigDecimal result = this.amount.subtract(other.amount);
        return new Money(result, this.currency);
    }

}
