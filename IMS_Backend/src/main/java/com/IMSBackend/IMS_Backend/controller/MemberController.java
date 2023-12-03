package com.IMSBackend.IMS_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.IMSBackend.IMS_Backend.repository.MemberRepository;
import com.IMSBackend.IMS_Backend.model.Member;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/member")
    Member newMember(@RequestBody Member newMember){
        return memberRepository.save(newMember);
    }

    @GetMapping("/member")
    List<Member> getAllMember(){
        return memberRepository.findAll();
    }


}
