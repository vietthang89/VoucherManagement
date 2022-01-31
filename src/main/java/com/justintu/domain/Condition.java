package com.justintu.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justintu.constants.ConditionOperator;
import com.justintu.constants.ConditionType;

import javax.persistence.*;

@Entity
@Table(name = "condition")
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer condition_id;

    private ConditionType conditionType;
    private ConditionOperator operator;
    private long value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_code", referencedColumnName="code", insertable=false, updatable=false)
    private Voucher voucher;

    public Condition() {
    }

    public Condition(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public Integer getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(Integer condition_id) {
        this.condition_id = condition_id;
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

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

}
