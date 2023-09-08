package com.kolis3.book_management_system.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.kolis3.book_management_system.dto.MemberReadDTO;

public interface MemberMapper {

    // Security Member Read
    MemberReadDTO getMamber(String memberEmail);

    String time();

    @Insert("insert into tbl_member (memberEmail, memberPw, memberName) values (#{email}, #{mpw}, #{mname})")
    int insertMember(
        @Param("email") String email,
        @Param("mpw") String mpw, 
        @Param("mname")String mname
    );
    
    @Insert("insert into tbl_member_role (memberEmail, rolename) values (#{email}, #{rolename})")
    int insertMemberRole(
      @Param("email") String email,
      @Param("rolename") String rolename
    );   
}