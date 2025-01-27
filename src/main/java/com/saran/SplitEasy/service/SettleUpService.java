package com.saran.SplitEasy.service;

import com.saran.SplitEasy.DAO.SettleUpDAO;
import com.saran.SplitEasy.RestModel.SettleUpWrapper;
import com.saran.SplitEasy.model.SettleUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettleUpService {
    @Autowired
    SettleUpDAO settleUpDAO;

    public void create(SettleUpWrapper settleUpWrapper) throws Exception{
        try {
            //todo need to update the pending amount
            SettleUp settleUp = new SettleUp();
            settleUp = settleUpWrapper.getSettleUp(settleUp);
            settleUpDAO.save(settleUp);
        }catch (Exception e){
            throw e;
        }
    }

    public void delete(int settleUpId) throws Exception{
        try {
            //todo need to update the pending amount
            Optional<SettleUp> settleUp = settleUpDAO.findById(settleUpId);
            if (settleUp.isEmpty()){
                throw new Exception("SettleUp with id : "+settleUpId+" not found");
            }
            settleUpDAO.delete(settleUp.get());
        }catch (Exception e){
            throw e;
        }
    }
}
