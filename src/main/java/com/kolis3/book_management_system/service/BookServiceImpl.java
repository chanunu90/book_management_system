package com.kolis3.book_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;
import com.kolis3.book_management_system.dto.PageResponseDTO;
import com.kolis3.book_management_system.mappers.BookMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookMapper bookMapper;
    
    @Override
    public List<BookDTO> getBookList(PageRequestDTO pageRequestDTO) {
        return bookMapper.getBookList(pageRequestDTO);
    }

    @Override
    public Long getListCount(PageRequestDTO pageRequestDTO) {
        return bookMapper.getListCount(pageRequestDTO);
    }
    
}
