package com.IMSBackend.IMS_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.IMSBackend.IMS_Backend.model.Member;
public interface MemberRepository extends JpaRepository<Member, Long> {

}
