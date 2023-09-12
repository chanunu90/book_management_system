package com.kolis3.book_management_system.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.BookImageDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;

public interface BookMapper {

    List<BookDTO> getBookList(PageRequestDTO pageRequestDTO);

    Long getListCount(PageRequestDTO pageRequestDTO);

    Long setBook(BookDTO BookDTO);

    void setBookImage(BookImageDTO imageDTO);

    void rentingBook(@Param("bno") Long bno, @Param("mno") Long mno);

    void returnBook(@Param("bno") Long bno);
    
}
