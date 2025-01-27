package com.saran.SplitEasy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class SettleUp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int settleId;

    @Column(nullable = false)
    private int paidFromUser;

    @Column(nullable = false)
    private int paidToUser;

    private int groupId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private SettleUpStatus status;

    @Column(nullable = false)
    private Date settleUpDate;

    public int getSettleId() {
        return settleId;
    }

    public void setSettleId(int settleId) {
        this.settleId = settleId;
    }

    public int getPaidFromUser() {
        return paidFromUser;
    }

    public void setPaidFromUser(int paidFromUser) {
        this.paidFromUser = paidFromUser;
    }

    public int getPaidToUser() {
        return paidToUser;
    }

    public void setPaidToUser(int paidToUser) {
        this.paidToUser = paidToUser;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public SettleUpStatus getStatus() {
        return status;
    }

    public void setStatus(SettleUpStatus status) {
        this.status = status;
    }

    public Date getSettleUpDate() {
        return settleUpDate;
    }

    public void setSettleUpDate(Date settleUpDate) {
        this.settleUpDate = settleUpDate;
    }
}
