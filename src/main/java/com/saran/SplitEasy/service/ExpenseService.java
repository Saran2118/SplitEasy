package com.saran.SplitEasy.service;

import com.saran.SplitEasy.DAO.ExpenseDAO;
import com.saran.SplitEasy.DAO.ExpenseDetailDAO;
import com.saran.SplitEasy.RestModel.ExpenseDetailWrapper;
import com.saran.SplitEasy.RestModel.ExpenseWrapper;
import com.saran.SplitEasy.model.Expense;
import com.saran.SplitEasy.model.ExpenseDetail;
import com.saran.SplitEasy.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseDAO expenseDAO;

    @Autowired
    ExpenseDetailDAO expenseDetailDAO;

//    public void updateBalance(Expense expense,boolean added){
//        List<>
//        for(ExpenseDetail expenseDetail :expense.getExpenseDetails()){
//            if(expenseDetail.getUserType().equals(UserType.PAID_USER)){
//
//            }
//        }
//    }
    public Expense addExpense(ExpenseWrapper expenseWrapper) throws Exception{
        Expense expense = null;
        try{
            //todo update balance
            expense=expenseWrapper.getExpense(expense);
            expense= expenseDAO.save(expense);
//            updateBalance(expense,true);
            return expense;
        }catch (Exception e){
            if(expense!=null){
                expenseDAO.delete(expense);
            }
            throw e;
        }
    }

    public void deleteExpense(int expenseId) throws Exception{
        try{
            //todo update balance
            Optional<Expense> expense=expenseDAO.findById(expenseId);
            if(expense.isEmpty()){
                throw new Exception("Expense with id : "+expenseId+" not exist.");
            }
            expenseDAO.delete(expense.get());
        }catch (Exception e){
            throw e;
        }
    }
}
