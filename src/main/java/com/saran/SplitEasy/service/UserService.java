package com.saran.SplitEasy.service;

import com.saran.SplitEasy.DAO.UserDAO;
import com.saran.SplitEasy.model.Group;
import com.saran.SplitEasy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public ResponseEntity saveUser(@RequestBody User user){
        try {
            User savedUser = userDAO.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity<>("Email id :"+user.getEmailId()+" already exist", HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity deleteUser(String email) {
        try {
            User user= userDAO.findByEmailId(email);
            userDAO.delete(user);
            return new ResponseEntity<>("User with email "+email+" deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            //todo logger
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public User getGroupById(int userId) throws Exception {
        try{
            Optional<User> user= userDAO.findById(userId);
            if(user.isEmpty()){
                throw new Exception("User with id : "+userId+" not found");
            }
            return user.get();
        }catch (Exception e){
            throw e;
        }
    }
}
