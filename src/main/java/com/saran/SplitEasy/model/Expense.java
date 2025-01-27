package com.saran.SplitEasy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "expense")
@Data
public class Expense {
    @Id
    @Column(name = "expense_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;

    @Column(name = "group_id",nullable = false)
    private int groupId;

    @Column(nullable = false)
    private String description;

    @Column(name = "expense_date",nullable = false)

    private java.util.Date expenseDate;

    @Column(name = "created_by_user_id",nullable = false)
    private int createdByUserId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private ExpenseStrategy strategy;

    @OneToMany(mappedBy = "expense",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<ExpenseDetail> expenseDetails;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ExpenseStrategy strategy) {
        this.strategy = strategy;
    }

    public List<ExpenseDetail> getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(List<ExpenseDetail> expenseDetails) {
        this.expenseDetails = expenseDetails;
    }
}
