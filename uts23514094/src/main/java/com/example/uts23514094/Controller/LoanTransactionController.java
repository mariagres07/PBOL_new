package com.example.uts23514094.Controller;

import com.example.uts23514094.Model.LoanTransaction;
import com.example.uts23514094.Service.LoanTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoanTransactionController {
    @Autowired
    private LoanTransactionService loanTransactionService;

    // Mendapatkan semua produk
    @GetMapping("/loanTransactions")
    public String viewLoanTransaction(Model model){
        List<LoanTransaction> loanTransactions = loanTransactionService.getAllLoanTransaction();
        model.addAttribute("loan transactions", loanTransactions);
        return "loanTransactions";
        //Mengarahkan ke file products.html
    }

    //Menampilkan form untuk menambahkan produk baru
    @GetMapping("/loanTransaction/new")
    public String showCreateLoanTransactionFormModel(Model model){
        LoanTransaction transactions = new LoanTransaction();
        model.addAttribute("loanTransaction", transactions);
        System.out.println("Product object sent to the view: " + transactions);
        return "form_loanTransaction";
    }

    //Menyimpan produk baru
    @PostMapping("/loanTransaction/save")
    public  String saveLoanTransaction(LoanTransaction transaction){
        loanTransactionService.saveLoanTransaction(transaction);
        return "redirect:/loanTransactions";
    }

    //Menampilkan form untuk mengedit produk
    @GetMapping("/loanTransaction/edit/{id}")
    public String showEditLoanTransactionForm(@PathVariable("id") Long id, Model model){
        LoanTransaction loanTransaction = loanTransactionService.getLoanTransactionById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", loanTransaction);
        return "form_loanTransaction";
        // Mengarahkan ke file product_form.html
    }
    // Menghapus produk
    @GetMapping("/loanTransaction/delete/{id}")
    public String loanTransactionService(@PathVariable("id") Long id, Model model){
        loanTransactionService.deleteLoanTransaction(id);
        return "redirect:/loanTransactions";
    }
}
