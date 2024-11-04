package org.example.utspbol_094.Service;

import org.example.utspbol_094.Model.LoanTransaction;
import org.example.utspbol_094.Repository.LoanTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanTransactionService {
    @Autowired
    private LoanTransactionRepository loanTransactionRepository;

    public List<LoanTransaction> getAllLoanTransaction(){ return loanTransactionRepository.findAll();}

    public LoanTransaction saveLoanTransaction(LoanTransaction loanTransaction){
        return loanTransactionRepository.save(loanTransaction);
    }

    public LoanTransaction updateLoanTransaction(Long id, LoanTransaction updatedLoanTransaction){
        Optional<LoanTransaction> bookOptional = loanTransactionRepository.findById(id);
        if (bookOptional.isPresent()) {
            LoanTransaction existingLoanTransaction = bookOptional.get();
            existingLoanTransaction.setBook(updatedLoanTransaction.getBook());
            existingLoanTransaction.setMember(updatedLoanTransaction.getMember());
            existingLoanTransaction.setBorrowDate(updatedLoanTransaction.getBorrowDate());
            existingLoanTransaction.setReturnDate(updatedLoanTransaction.getReturnDate());
            return loanTransactionRepository.save(existingLoanTransaction);
        }
        return null;
    }

    public void deleteLoanTransaction(Long id){
        loanTransactionRepository.deleteById(id);
    }
}
