package com.saran.SplitEasy.RestModel;

import com.saran.SplitEasy.model.Expense;
import com.saran.SplitEasy.model.ExpenseDetail;
import com.saran.SplitEasy.model.ExpenseStrategy;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseWrapper {
    private int groupId;

    private String description;

    private long expenseDate;

    private int createdByUserId;

    private double amount;

    private ExpenseStrategy strategy;

    private List<ExpenseDetailWrapper> expenseDetailList;

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

    public long getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(long expenseDate) {
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

    public List<ExpenseDetailWrapper> getExpenseDetailList() {
        return expenseDetailList;
    }

    public void setExpenseDetailList(List<ExpenseDetailWrapper> expenseDetailList) {
        this.expenseDetailList = expenseDetailList;
    }

    public Expense getExpense(Expense expense){
        if(expense==null){
            expense=new Expense();
        }
        expense.setGroupId(this.getGroupId());
        expense.setDescription(this.getDescription());
        expense.setExpenseDate(new Date(this.getExpenseDate()));
        expense.setCreatedByUserId(this.getCreatedByUserId());
        expense.setAmount(this.getAmount());
        expense.setStrategy(this.getStrategy());
        List<ExpenseDetail> expenseDetails = new ArrayList<>();
        for(ExpenseDetailWrapper expenseDetailWrapper : this.getExpenseDetailList()){
            ExpenseDetail expenseDetail = new ExpenseDetail();
            expenseDetail.setAmount(expenseDetailWrapper.getAmount());
            expenseDetail.setUserId(expenseDetailWrapper.getUserId());
            expenseDetail.setUserType(expenseDetailWrapper.getUserType());
            expenseDetail.setExpense(expense);
            expenseDetails.add(expenseDetail);
        }
        expense.setExpenseDetails(expenseDetails);
        return expense;
    }

}
