package com.example.uts23514094.Repository;

import com.example.uts23514094.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
