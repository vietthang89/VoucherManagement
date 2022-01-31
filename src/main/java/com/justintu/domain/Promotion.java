package com.justintu.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotion_id;

    @Column(nullable = false)
    private String name;
    private String description;

    private boolean stackable;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Promotion() {
    }

    public Promotion(String name, boolean stackable, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.stackable = stackable;
        this.startTime = startTime;
        this.endTime = endTime;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
//    private Set<Voucher> vouchers = new HashSet<Voucher>(0);

    public Integer getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Integer promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

//    public Set<Voucher> getVouchers() {
//        return vouchers;
//    }
//
//    public void setVouchers(Set<Voucher> vouchers) {
//        this.vouchers = vouchers;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
