package com.justintu.constants;

public enum ProductType {
    CLOTHES(1), FOOD_AND_BEVERAGES(2);

    private int type;

    ProductType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
