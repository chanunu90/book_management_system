package com.kolis3.book_management_system.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.kolis3.book_management_system.dto.MemberReadDTO;

public interface MemberMapper {

    // Security Member Read
    MemberReadDTO selectOne(String email);

    String time();

    @Insert("insert into tbl_member (email,mpw, mname) values (#{email}, #{mpw}, #{mname})")
    int insertMember(
        @Param("email") String email, 
        @Param("mpw") String mpw, 
        @Param("mname")String mname);
    
    @Insert("insert into tbl_member_role (email, rolename) values (#{email}, #{rolename})")
    int insertMemberRole(
      @Param("email") String email,
      @Param("rolename") String rolename
    );   
}