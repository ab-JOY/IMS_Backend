package com.IMSBackend.IMS_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.IMSBackend.IMS_Backend.repository.MemberRepository;
import com.IMSBackend.IMS_Backend.model.Member;
import com.IMSBackend.IMS_Backend.exception.MemberNotFoundException;

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

    @GetMapping("/member/{id}")
    Member getMemberById(@PathVariable Long id){
        return memberRepository.findById(id)
                .orElseThrow(()->new MemberNotFoundException(id));
    }

    @PutMapping("/member/{id}")
    Member updateMember(@RequestBody Member newMember, @PathVariable Long id){
        return memberRepository.findById(id)
                .map(member -> {
                    member.setFirstName(newMember.getFirstName());
                    member.setMiddleName(newMember.getMiddleName());
                    member.setLastName(newMember.getLastName());
                    member.setDateOfBirth(newMember.getDateOfBirth());
                    member.setSex(newMember.getSex());
                    member.setAddress(newMember.getAddress());
                    member.setMobileNumber(newMember.getMobileNumber());
                    member.setMembershipType(newMember.getMembershipType());

                    return memberRepository.save(member);
                }).orElseThrow(()->new MemberNotFoundException(id));
    }

    @DeleteMapping("/member/{id}")
    String deleteMember(@PathVariable Long id){
        if(!memberRepository.existsById(id)){
            throw new MemberNotFoundException(id);
        }
        memberRepository.deleteById(id);
        return "Member with id: " +id+ " has been deleted successfully";
    }
}