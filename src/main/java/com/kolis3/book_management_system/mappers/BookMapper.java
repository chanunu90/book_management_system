package com.kolis3.book_management_system.mappers;

import java.util.List;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;

public interface BookMapper {

    List<BookDTO> getBookList(PageRequestDTO pageRequestDTO);

    Long getListCount(PageRequestDTO pageRequestDTO);

    Long addBook(BookDTO BookDTO);

    Long updateBook(BookDTO BookDTO);
    
    Long deleteBook(BookDTO BookDTO);
    
}
