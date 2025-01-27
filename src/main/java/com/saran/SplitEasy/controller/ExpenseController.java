package com.saran.SplitEasy.controller;

import com.saran.SplitEasy.RestModel.ExpenseWrapper;
import com.saran.SplitEasy.model.Expense;
import com.saran.SplitEasy.service.ExpenseService;
import com.saran.SplitEasy.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    InputValidator validator;

    @PostMapping("add")
    public ResponseEntity addExpense(@RequestBody ExpenseWrapper expenseWrapper){
        try{
            validator.validateExpense(expenseWrapper);
            Expense expense = expenseService.addExpense(expenseWrapper);
            return new ResponseEntity("Expense created successfully",HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{expenseId}")
    public ResponseEntity deleteExpense(@PathVariable int expenseId){
        try{
            expenseService.deleteExpense(expenseId);
            return new ResponseEntity("Expense with id "+expenseId+" is deleted successfully",HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
