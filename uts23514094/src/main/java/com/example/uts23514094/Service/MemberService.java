package com.example.uts23514094.Service;

import com.example.uts23514094.Model.Member;
import com.example.uts23514094.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id){
        return memberRepository.findById(id);
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}