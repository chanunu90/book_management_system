package com.kolis3.book_management_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.MemberReadDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;
import com.kolis3.book_management_system.dto.PageResponseDTO;
import com.kolis3.book_management_system.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    //로그인페이지로
    @PreAuthorize("permitAll")
    @GetMapping("/signin")
        public void signin(){
        log.info("signin----------");

    }

    //로그인페이지로
    @PreAuthorize("permitAll")
    @GetMapping("/signupPage")
        public String signupPage(){
        log.info("signupPage----------");

        return "/member/signup";

    }


    //회원가입
    @PostMapping("/signup")
    public String signup(MemberReadDTO memberReadDTO){
        log.info("signup----------");
        log.info(memberReadDTO);

        List<String> role = new ArrayList<>();
        role.add(0, "ROLE_USER");
        //암호화해서 다시 넣어줌
        memberReadDTO.setMemberPw(passwordEncoder.encode(memberReadDTO.getMemberPw()));
        memberReadDTO.setRolenames(role);
        memberReadDTO.setRoleName("ROLE_USER");

        log.info(memberReadDTO);

        memberService.setMember(memberReadDTO);


        //다시 로그인 페이지로
        return "redirect:/member/signin";

    }

    //로그인작업
    



}
