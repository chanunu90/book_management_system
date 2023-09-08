package com.kolis3.book_management_system.service;

import org.springframework.stereotype.Service;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.PageResponseDTO;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BookServiceImpl implements BookService{
    
    
    @Override
    public PageResponseDTO<BookDTO> getBookList() {

        return 
    }
    
}
