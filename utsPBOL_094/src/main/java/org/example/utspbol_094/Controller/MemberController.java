package org.example.utspbol_094.Controller;

import org.example.utspbol_094.Model.Member;
import org.springframework.ui.Model;
import org.example.utspbol_094.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public String getAllMember(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "member_list";
    }
    @GetMapping("/member/new")
    public String showMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "member_form";
    }
    @PostMapping("/member/save")
    public String saveMember(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/members";
    }

    @GetMapping("/member/edit/{id}")
    public String editMember(@PathVariable("id") Long id, Model model){
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            model.addAttribute("member", memberOptional.get());
            return "member_form";
        }
        return "redirect:/members";
        }

    @PutMapping("/member/update/{id}")
    public String updateMember(@PathVariable("id") Long id, @ModelAttribute Member updatedMember) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            Member existingMember = memberOptional.get();
            existingMember.setName(updatedMember.getName());
            existingMember.setEmail(updatedMember.getEmail());
            existingMember.setMembershipDate(updatedMember.getMembershipDate());
            memberRepository.save(existingMember);
        }
        return "redirect:/members";
    }


    @GetMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
        return "redirect:/members";
    }
}
