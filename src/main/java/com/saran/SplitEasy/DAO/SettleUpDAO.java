package com.saran.SplitEasy.DAO;

import com.saran.SplitEasy.model.SettleUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface SettleUpDAO extends JpaRepository<SettleUp, Integer> {

}
