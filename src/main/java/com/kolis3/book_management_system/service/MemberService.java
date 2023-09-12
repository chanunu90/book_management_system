package com.kolis3.book_management_system.service;

import org.springframework.transaction.annotation.Transactional;

import com.kolis3.book_management_system.dto.MemberReadDTO;

@Transactional
public interface MemberService {
    
    MemberReadDTO getMember(String memberEmail);

    void setMember(MemberReadDTO memberReadDTO);

    




}
