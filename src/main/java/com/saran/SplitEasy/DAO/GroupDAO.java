package com.saran.SplitEasy.DAO;

import com.saran.SplitEasy.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDAO extends JpaRepository<Group,Integer> {
}
