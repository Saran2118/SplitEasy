package com.saran.SplitEasy.RestModel;

import com.saran.SplitEasy.model.UserType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

public class ExpenseDetailWrapper {

    private UserType userType;

    private int userId;
    private double amount;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
