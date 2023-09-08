package com.kolis3.book_management_system.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;
import com.kolis3.book_management_system.dto.PageResponseDTO;
import com.kolis3.book_management_system.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/")
public class BookApiController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("bookList")
    public PageResponseDTO<BookDTO> booklist(PageRequestDTO pageRequestDTO){

        PageResponseDTO<BookDTO> booklist = bookService.getBookList();
        log.info("booklist---------------");
        log.info(booklist);

        return booklist;
    }
    

}
