package com.saran.SplitEasy.validator;

import com.saran.SplitEasy.RestModel.ExpenseDetailWrapper;
import com.saran.SplitEasy.RestModel.ExpenseWrapper;
import com.saran.SplitEasy.model.Group;
import com.saran.SplitEasy.model.User;
import com.saran.SplitEasy.model.UserType;
import com.saran.SplitEasy.service.GroupService;
import com.saran.SplitEasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class InputValidator {

    @Autowired
    GroupService groupService;

    @Autowired
    UserService userService;

    public boolean validateUser(User user) throws Exception{
        validateEmail(user.getEmailId());
        validateUserName(user.getUserName());
        return true;
    }

    private void validateUserName(String userName) throws Exception {
        String USERNAME_REGEX="^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(userName);
        if(!matcher.matches()){
            throw  new Exception("Invalid user name. User name should contain only alphabets");
        }
    }

    public void validateEmail(String email) throws Exception {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            throw  new Exception("Invalid email id");
        }
    }

    public void validateGroupById(int groupId) throws Exception {
        Group group=groupService.getGroupById(groupId);
        if(group==null){
            throw new Exception("Group with id : "+groupId+" not found");
        }
    }

    public void validateUserById(int userId) throws Exception {
        User user=userService.getGroupById(userId);
        if(user==null){
            throw new Exception("User with id : "+userId+" not found");
        }
    }

    public void validateExpense(ExpenseWrapper expenseWrapper) throws Exception{
        validateGroupById(expenseWrapper.getGroupId());
        validateUserById(expenseWrapper.getCreatedByUserId());
        double expenseAmount=0;
        double paidAmount=0;
        for(ExpenseDetailWrapper expenseDetailWrapper : expenseWrapper.getExpenseDetailList()){
            validateUserById(expenseDetailWrapper.getUserId());
            if(expenseDetailWrapper.getUserType().equals(UserType.OWES_USER))
                expenseAmount+=expenseDetailWrapper.getAmount();
            else if(expenseDetailWrapper.getUserType().equals(UserType.PAID_USER)) {
                expenseAmount -= expenseDetailWrapper.getAmount();
                paidAmount += expenseDetailWrapper.getAmount();
            }
        }
        if(expenseAmount!=0 || paidAmount!=expenseWrapper.getAmount() ){
            throw new Exception("Expense Amount not matched...");
        }
    }
}
