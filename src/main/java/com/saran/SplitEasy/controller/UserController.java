package com.saran.SplitEasy.controller;

import com.saran.SplitEasy.model.User;
import com.saran.SplitEasy.service.UserService;
import com.saran.SplitEasy.validator.InputValidator;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    InputValidator validator;

    @PostMapping("save")
    public ResponseEntity saveUser(@RequestBody User user){
        try{
            validator.validateUser(user);
            return userService.saveUser(user);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{email}")
    public ResponseEntity deleteUser(@PathVariable("email") String email){
        try{
            validator.validateEmail(email);
            return userService.deleteUser(email);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("user")
    public String getUser(){
            return "hello";
    }
}
