package com.kolis3.book_management_system.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;

@Transactional
public interface BookService {

    List<BookDTO> getBookList(PageRequestDTO pageRequestDTO);

    Long getListCount(PageRequestDTO pageRequestDTO);
    
    Long setBook(BookDTO bookDTO);

    void rentingBook(Long bno, Long mno);

    void returnBook(Long bno);
    
}
