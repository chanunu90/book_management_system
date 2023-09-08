package com.kolis3.book_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.kolis3.book_management_system.dto.PageRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/book")
public class BookController {

    //책 리스트 페이지
    @PreAuthorize("permitAll")
    @GetMapping("/bookList")
        public void bookList(PageRequestDTO pageRequestDTO ){
        log.info("bookList----------");
    }




}
