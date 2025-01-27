package com.saran.SplitEasy.DAO;

import com.saran.SplitEasy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {

    User findByEmailId(String email);
}
