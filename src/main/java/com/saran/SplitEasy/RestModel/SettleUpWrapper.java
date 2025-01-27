package com.saran.SplitEasy.RestModel;

import com.saran.SplitEasy.model.SettleUp;
import com.saran.SplitEasy.model.SettleUpStatus;
import jakarta.persistence.Column;

import java.util.Date;

public class SettleUpWrapper {
    private int paidFromUser;

    private int paidToUser;

    private int groupId;

    private double amount;

    private SettleUpStatus status;

    private long settleUpDate;

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

    public long getSettleUpDate() {
        return settleUpDate;
    }

    public void setSettleUpDate(long settleUpDate) {
        this.settleUpDate = settleUpDate;
    }

    public SettleUp getSettleUp(SettleUp settleUp) {
        if (settleUp==null){
            settleUp=new SettleUp();
        }
        settleUp.setAmount(this.getAmount());
        settleUp.setSettleUpDate(new Date(this.getSettleUpDate()));
        settleUp.setGroupId(this.getGroupId());
        settleUp.setStatus(this.getStatus());
        settleUp.setPaidFromUser(this.getPaidFromUser());
        settleUp.setPaidToUser(this.getPaidToUser());
        return  settleUp;
    }
}
