package com.workshop.prices_rules_inventory_kata.domain.exceptions;

public class InvalidMoneyException extends RuntimeException {
    public InvalidMoneyException(String message) {
        super(message);
    }
}
