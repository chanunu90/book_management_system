package com.kolis3.book_management_system.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kolis3.book_management_system.dto.MemberDTO;
import com.kolis3.book_management_system.dto.MemberReadDTO;
import com.kolis3.book_management_system.mappers.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

// Custom User Details Servier Class
@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Is Running LoadUserByUserName");
        log.info("username"+ username);
        //추후 연구가 필요
        // username = "user@user.com";
        // log.info("username"+ username);

        MemberReadDTO memberReadDTO = memberMapper.getMamber(username);
        log.info("readDTO"+ memberReadDTO);

        MemberDTO memberDTO = new MemberDTO(username,
                memberReadDTO.getMemberPw(),
                memberReadDTO.getMemberName(),
                memberReadDTO.getRolenames());
        return memberDTO;
    }
}
