package org.example.utspbol_094.Service;

import org.example.utspbol_094.Model.Member;
import org.example.utspbol_094.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    public MemberRepository memberRepository;

    public List<Member> getAllMembers(){ return memberRepository.findAll();}

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            Member existingMember = memberOptional.get();
            existingMember.setName(updatedMember.getName());
            existingMember.setEmail(updatedMember.getEmail());
            existingMember.setMembershipDate(updatedMember.getMembershipDate());
            return memberRepository.save(existingMember);
        }
        return null;

        }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
