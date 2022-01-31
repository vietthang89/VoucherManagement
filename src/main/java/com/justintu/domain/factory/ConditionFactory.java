package com.justintu.domain.factory;


import com.justintu.constants.ConditionOperator;
import com.justintu.constants.ConditionType;
import com.justintu.constants.ProductType;
import com.justintu.domain.Condition;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class ConditionFactory {

    public static Set<Condition> createDateRangeConditions(LocalDateTime startTime, LocalDateTime endTime) {
        ZoneId zoneId = ZoneId.systemDefault();

        Set conditions = new HashSet();
        Condition start = new Condition(ConditionType.DATE_RANGE);
        start.setOperator(ConditionOperator.GREATER);
        start.setValue(startTime.atZone(zoneId).toEpochSecond());
        conditions.add(start);

        Condition end = new Condition(ConditionType.DATE_RANGE);
        end.setOperator(ConditionOperator.SMALLER);
        end.setValue(endTime.atZone(zoneId).toEpochSecond());
        conditions.add(end);

        return conditions;
    }

    public static Set<Condition> createLimitedTimeConditions(int time) {
        Condition condition = new Condition(ConditionType.LIMITED_TIME);
        condition.setValue(time);

        return Collections.singleton(createLimitedTimeCondition(time));
    }

    public static Condition createLimitedTimeCondition(int time) {
        Condition condition = new Condition(ConditionType.LIMITED_TIME);
        condition.setValue(time);
        return condition;
    }

    public static Condition createAmountCondition(long amount) {
        Condition condition = new Condition(ConditionType.CART_AMOUNT);
        condition.setValue(amount);

        return condition;
    }

    public static Condition createProductTypeCondition(ProductType type) {
        Condition condition = new Condition(ConditionType.SPECIFIC_PRODUCT_TYPE);
        condition.setValue(type.getType());
        return condition;
    }


    public static List<Condition> createMultipleProductTypeCondition(List<ProductType> types) {

        List conditions = new ArrayList();
        types.stream().forEach(type -> {
            conditions.add(createProductTypeCondition(type));
        });

        return conditions;
    }

}
