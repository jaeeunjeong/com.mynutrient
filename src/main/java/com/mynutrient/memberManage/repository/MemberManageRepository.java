package com.mynutrient.memberManage.repository;

import com.mynutrient.memberManage.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberManageRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
