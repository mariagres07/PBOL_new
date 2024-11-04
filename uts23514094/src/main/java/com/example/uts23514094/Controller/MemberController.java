package com.example.uts23514094.Controller;

import com.example.uts23514094.Model.Member;
import com.example.uts23514094.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    // Mendapatkan semua produk
    @GetMapping("/members")
    public String viewProducts(Model model){
        List<Member> members = memberService.getAllMember();
        model.addAttribute("members", members);
        return "members";
        //Mengarahkan ke file products.html
    }

    //Menampilkan form untuk menambahkan produk baru
    @GetMapping("/member/new")
    public String showCreateMemberFormModel(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        System.out.println("Member sent to the view: " + member);
        return "form_member";
    }

    //Menyimpan produk baru
    @PostMapping("/member/save")
    public  String saveProduct(Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }

    //Menampilkan form untuk mengedit produk
    @GetMapping("/book/edit/{id}")
    public String showEditMembertForm(@PathVariable("id") Long id, Model model){
        Member orang = memberService.getMemberById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("orang", orang);
        return "form_member";
        // Mengarahkan ke file product_form.html
    }
    // Menghapus produk
    @GetMapping("/member/delete/{id}")
    public String memberService(@PathVariable("id") Long id, Model model){
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}
