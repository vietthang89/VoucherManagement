package com.justintu.constants;

public enum ConditionOperator {

    EQUAL("="), GREATER(">"), SMALLER("<");

    private String symbol;

    ConditionOperator(String symbol) {
        this.symbol = symbol;
    }
}
