package com.saran.SplitEasy.controller;

import com.saran.SplitEasy.RestModel.SettleUpWrapper;
import com.saran.SplitEasy.service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("settleup")
public class SettleUpController {
    @Autowired
    SettleUpService settleUpService;

    @PostMapping("add")
    public ResponseEntity createSettleUp(@RequestBody SettleUpWrapper settleUpWrapper){
        try {
            settleUpService.create(settleUpWrapper);
            return new ResponseEntity("Settled up successfully to user "+settleUpWrapper.getPaidToUser(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{settleUpId}")
    public ResponseEntity deleteSettleUp(@PathVariable int settleUpId){
        try {
            settleUpService.delete(settleUpId);
            return new ResponseEntity("Settled up deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
