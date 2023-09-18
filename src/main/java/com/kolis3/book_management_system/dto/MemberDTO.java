package com.kolis3.book_management_system.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class MemberDTO extends User{


    private String memberEmail;
    private String memberName;
    private String memberPw;
    private List<String> roleNames = new ArrayList<>();

    public MemberDTO(String memberEmail, String memberPw, String memberName, List<String> roleNames) {

        // super(email,mpw, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        super(memberEmail, memberPw,roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_" + str)).collect(Collectors.toList()));
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.roleNames = roleNames;
    }

}
