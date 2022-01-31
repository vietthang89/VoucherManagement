package com.justintu.dto;

import com.justintu.constants.RedemptionType;
import com.justintu.constants.VoucherType;

import java.util.Set;

public class VoucherDTO {

    private String name;

    // private VoucherType type;

    private String description;

    private RedemptionType redemptionType;

    private Set<ConditionDTO> conditions;

    public VoucherDTO() {
    }

    public VoucherDTO(String name, String description, RedemptionType redemptionType, Set<ConditionDTO> conditions) {
        this.name = name;
        this.description = description;
        this.redemptionType = redemptionType;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RedemptionType getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(RedemptionType redemptionType) {
        this.redemptionType = redemptionType;
    }

    public Set<ConditionDTO> getConditions() {
        return conditions;
    }

    public void setConditions(Set<ConditionDTO> conditions) {
        this.conditions = conditions;
    }
}
