package com.kolis3.book_management_system.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookImageDTO {
  
  private Long image_bno;

  //DB 처리 용도
  private String image;

  @Builder.Default
  private List<String> images = new ArrayList<>();

  private int ord;
  
}
