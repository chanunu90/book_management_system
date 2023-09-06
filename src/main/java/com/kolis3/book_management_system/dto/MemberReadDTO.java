package com.kolis3.book_management_system.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberReadDTO {

    private String memberId;

    private String memberPw;

    private String memberName;

    private String memberAddress;

    private String memberTel;

    private List<String> rolenames;



    
}