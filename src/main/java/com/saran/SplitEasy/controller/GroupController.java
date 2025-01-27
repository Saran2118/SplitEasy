package com.saran.SplitEasy.controller;

import com.saran.SplitEasy.RestModel.GroupWrapper;
import com.saran.SplitEasy.model.Group;
import com.saran.SplitEasy.service.GroupService;
import com.saran.SplitEasy.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @Autowired
    InputValidator validator;

    @PostMapping("create")
    public ResponseEntity createGroup(@RequestBody GroupWrapper groupWrapper){
        try {
            Group group=groupService.createGroup(groupWrapper);
            return new ResponseEntity(group, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("addMember/{groupId}/{userId}")
    public ResponseEntity addMemberToGroup(@PathVariable int groupId,
                                      @PathVariable int userId){
        try {
            validator.validateGroupById(groupId);
            Group group=groupService.addMemberToGroup(groupId,userId);
            return new ResponseEntity(group, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
