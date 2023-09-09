package com.kolis3.book_management_system.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {

    private Long bno;

    private String bookName;

    private String author;

    private String publishing;
    
    private String plot;

    private LocalDateTime regDate;


    
}
