package com.justintu.dto;

import com.justintu.constants.ConditionOperator;
import com.justintu.constants.ConditionType;


public class ConditionDTO {

    private ConditionType conditionType;

    private ConditionOperator operator;

    private long value;

    public ConditionDTO() {
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public ConditionOperator getOperator() {
        return operator;
    }

    public void setOperator(ConditionOperator operator) {
        this.operator = operator;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
