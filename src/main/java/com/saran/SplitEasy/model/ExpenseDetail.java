package com.saran.SplitEasy.model;

import jakarta.persistence.*;

@Entity
public class ExpenseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int expenseDetailId;

    UserType userType;

    int userId;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    Expense expense;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

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

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

}
