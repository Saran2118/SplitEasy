package com.saran.SplitEasy.DAO;

import com.saran.SplitEasy.model.ExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDetailDAO extends JpaRepository<ExpenseDetail, Integer> {
}
