package com.kolis3.book_management_system.service;

import org.springframework.transaction.annotation.Transactional;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.PageResponseDTO;

@Transactional
public interface BookService {

    PageResponseDTO<BookDTO> getBookList();
    
}
