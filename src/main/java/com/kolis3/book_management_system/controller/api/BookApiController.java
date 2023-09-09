package com.kolis3.book_management_system.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public PageResponseDTO<BookDTO> bookList(PageRequestDTO pageRequestDTO){


        log.info("bookList--------API-------");

        //책리스트
        List<BookDTO> list = bookService.getBookList(pageRequestDTO);

        //책총수
        Long total = bookService.getListCount(pageRequestDTO);

        log.info("bookList---------------");
        log.info(list);

        return PageResponseDTO.<BookDTO>withAll()
        .list(list)
        .total(total)
        .pageRequestDTO(pageRequestDTO)
        .build();

    }

    //책 입력 부터 시작하면 됨

    @PostMapping("")
    public void addBook(BookDTO bookDTO){




    }
    

}
