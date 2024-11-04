package org.example.utspbol_094.Controller;

import org.example.utspbol_094.Repository.BookRepository;
import org.example.utspbol_094.Repository.MemberRepository;
import org.springframework.ui.Model;
import org.example.utspbol_094.Model.LoanTransaction;
import org.example.utspbol_094.Repository.LoanTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LoanTransactionController {
    @Autowired
    private LoanTransactionRepository loanTransactionRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/loanTransactions")
    public String getAllLoanTransaction(Model model) {
        List<LoanTransaction> loanTransactions = loanTransactionRepository.findAll();
        model.addAttribute("loanTransactions", loanTransactions);
        return "loanTransaction_list";
    }

    @GetMapping("/loanTransaction/new")
    public String showLoanTransactionForm(Model model) {
        model.addAttribute("loanTransaction", new LoanTransaction());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("members", memberRepository.findAll());
        return "loanTransaction_form";
    }

    @PostMapping("/loanTransaction/save")
    public String saveLoanTransaction(@ModelAttribute LoanTransaction loanTransaction) {
        loanTransactionRepository.save(loanTransaction);
        return "redirect:/loanTransactions";
    }

    @GetMapping("/loanTransaction/edit/{id}")
    public String editLoanTransaction(@PathVariable("id") Long id, Model model) {
        Optional<LoanTransaction> loanTransactionOptional = loanTransactionRepository.findById(id);
        if (loanTransactionOptional.isPresent()) {
            model.addAttribute("loanTransaction", loanTransactionOptional.get());
            model.addAttribute("books", bookRepository.findAll());
            model.addAttribute("members", memberRepository.findAll());
            return "loanTransaction_form";
        }
        return "redirect:/loanTransactions";
    }

    @PutMapping("/loanTransaction/update/{id}")
    public String updateLoanTransaction(@PathVariable("id") Long id, @ModelAttribute LoanTransaction updatedLoanTransaction) {
        Optional<LoanTransaction> loanTransactionOptional = loanTransactionRepository.findById(id);
        if (loanTransactionOptional.isPresent()) {
            LoanTransaction existingLoanTransaction = loanTransactionOptional.get();
            existingLoanTransaction.setBook(updatedLoanTransaction.getBook());
            existingLoanTransaction.setMember(updatedLoanTransaction.getMember());
            existingLoanTransaction.setBorrowDate(updatedLoanTransaction.getBorrowDate());
            existingLoanTransaction.setReturnDate(updatedLoanTransaction.getReturnDate());

            loanTransactionRepository.save(existingLoanTransaction);
        }
        return "redirect:/loanTransactions";
    }

    @GetMapping("/loanTransaction/delete/{id}")
    public String deleteLoanTransaction(@PathVariable("id") Long id) {
        loanTransactionRepository.deleteById(id);
        return "redirect:/loanTransactions";
    }

}
