package com.saran.SplitEasy.service;

import com.saran.SplitEasy.DAO.GroupDAO;
import com.saran.SplitEasy.DAO.UserDAO;
import com.saran.SplitEasy.RestModel.GroupWrapper;
import com.saran.SplitEasy.model.Group;
import com.saran.SplitEasy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    GroupDAO groupDAO;

    @Autowired
    UserDAO userDAO;

    public Group createGroup(GroupWrapper groupWrapper) throws Exception {
        try{
            Group newGroup= new Group();
            newGroup.setGroupName(groupWrapper.getGroupName());
            newGroup.setCreatedUserId(groupWrapper.getCreatedUserId());
            List<User> groupMembers= new ArrayList<>();
            for(int userId : groupWrapper.getGroupMembers()){
                Optional<User> user= userDAO.findById(userId);
                if(user.isEmpty()){
                    throw new Exception("UserId : "+userId +" not exist");
                }
                groupMembers.add(user.get());
            }
            newGroup.setMembers(groupMembers);
            return groupDAO.save(newGroup);
        }catch (Exception e){
            throw e;
        }
    }

    public Group addMemberToGroup(int groupId, int userId) throws Exception {
        try{
            Optional<Group> group=groupDAO.findById(groupId);
            if(group.isEmpty()){
                throw new Exception("Group : "+groupId +" not exist");
            }
            for(User existingMember : group.get().getMembers()){
                if(existingMember.getUserId()==userId){
                    throw new Exception("User : "+userId+" already exist in the group : "+groupId);
                }
            }
            Optional<User> user=userDAO.findById(userId);
            if(user.isEmpty()){
                throw new Exception("User : "+userId +" not exist");
            }
            group.get().addMember(user.get());
            return groupDAO.save(group.get());
        }catch (Exception e){
            throw e;
        }
    }

    public Group getGroupById(int groupId) throws Exception {
        try{
            Optional<Group> group= groupDAO.findById(groupId);
            if(group.isEmpty()){
                throw new Exception("Group with id : "+groupId+" not found");
            }
            return group.get();
        }catch (Exception e){
            throw e;
        }
    }
}
