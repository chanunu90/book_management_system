package com.kolis3.book_management_system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kolis3.book_management_system.dto.MemberReadDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {

    @PreAuthorize("permitAll")
    @GetMapping("/signin")
        public void signin(){
        log.info("signin----------");

    }


    @PostMapping("/signingo")
    public void signingo(MemberReadDTO memberReadDTO){
        log.info("signingo----------");
        log.info(memberReadDTO);

    }
    
}
