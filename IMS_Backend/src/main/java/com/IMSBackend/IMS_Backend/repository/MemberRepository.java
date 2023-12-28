package com.IMSBackend.IMS_Backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.IMSBackend.IMS_Backend.model.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
