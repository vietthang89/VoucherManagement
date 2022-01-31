package com.justintu.domain;

import com.justintu.constants.RedemptionType;
import com.justintu.constants.VoucherStatus;
import com.justintu.constants.VoucherType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "voucher")
public class Voucher {

    @Id
    private String code;

    private String name;

    // using this for calculating payment amount
    // private VoucherType type;

    private String description;

    private VoucherStatus status;

    private RedemptionType redemptionType;

    private int currentApplied;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "promotion_id", nullable = false)
//    @JsonIgnore
//    private Promotion promotion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<Condition> conditions = new HashSet<Condition>(0);

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VoucherStatus getStatus() {
        return status;
    }

    public void setStatus(VoucherStatus status) {
        this.status = status;
    }

    public RedemptionType getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(RedemptionType redemptionType) {
        this.redemptionType = redemptionType;
    }

    public int getCurrentApplied() {
        return currentApplied;
    }

    public void setCurrentApplied(int currentApplied) {
        this.currentApplied = currentApplied;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setType(VoucherType type) {
//        this.type = type;
//    }
//
//    public VoucherType getType() {
//        return type;
//    }

    public Set<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
    }
}

