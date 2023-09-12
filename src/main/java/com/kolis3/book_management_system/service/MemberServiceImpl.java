package com.kolis3.book_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kolis3.book_management_system.dto.MemberReadDTO;
import com.kolis3.book_management_system.mappers.MemberMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService{
    
    @Autowired
    private MemberMapper memberMapper; 
    
    @Override
    public MemberReadDTO getMember(String memberEmail) {

        return memberMapper.getMamber(memberEmail);

    }

    @Override
    public void setMember(MemberReadDTO memberReadDTO) {
        
        memberMapper.setMember(memberReadDTO);

    }




    
}
