package com.example.uts23514094.Service;

import com.example.uts23514094.Model.LoanTransaction;
import com.example.uts23514094.Repository.LoanTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanTransactionService {
    @Autowired
    private LoanTransactionRepository loanTransactionRepository;

    public List<LoanTransaction> getAllLoanTransaction(){
        return loanTransactionRepository.findAll();
    }

    public Optional<LoanTransaction> getLoanTransactionById(Long id){
        return loanTransactionRepository.findById(id);
    }

    public LoanTransaction saveLoanTransaction(LoanTransaction loanTransaction){
        return loanTransactionRepository.save(loanTransaction);
    }

    public void deleteLoanTransaction(Long id){
        loanTransactionRepository.deleteById(id);
    }
}
