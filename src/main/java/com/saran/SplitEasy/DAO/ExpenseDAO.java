package com.saran.SplitEasy.DAO;

import com.saran.SplitEasy.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDAO extends JpaRepository<Expense,Integer> {
}
