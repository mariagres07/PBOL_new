package com.example.uts23514094.Repository;

import com.example.uts23514094.Model.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, Long> {
}
