package com.kolis3.book_management_system.memberTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kolis3.book_management_system.mappers.MemberMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class BookManagementSystemApplicationTests {

    @Autowired
    private MemberMapper memberMapper;

	@Test
	void contextLoads() {

        log.info(memberMapper.time());

	}

}
