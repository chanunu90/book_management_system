package com.kolis3.book_management_system.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kolis3.book_management_system.dto.BookDTO;
import com.kolis3.book_management_system.dto.BookImageDTO;
import com.kolis3.book_management_system.dto.PageRequestDTO;
import com.kolis3.book_management_system.dto.PageResponseDTO;
import com.kolis3.book_management_system.mappers.BookMapper;

import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    //예외처리
    public static class UploadException extends RuntimeException{

        public UploadException(String msg){
            super(msg);
        }
    }
    
    private final BookMapper bookMapper;

    private final ServletContext servletContext;

    @Value("${com.kolis3.upload.path}")
    private String path;
    
    @Override
    public List<BookDTO> getBookList(PageRequestDTO pageRequestDTO) {
        return bookMapper.getBookList(pageRequestDTO);
    }

    @Override
    public Long getListCount(PageRequestDTO pageRequestDTO) {
        return bookMapper.getListCount(pageRequestDTO);
    }

    @Override
    public Long setBook(BookDTO bookDTO) {
        
        
        List<MultipartFile> files = bookDTO.getFiles();
        
        //파일을 저장하고 이름만 추출
        // if(files == null || files.size() == 0) {
        //     throw new UploadException("No File");
        // }

        List<String> uploadFileNames = new ArrayList<>();
        
       //loop
        for (MultipartFile mFile : files) {

            String originalFileName = mFile.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();

            String mimeType = servletContext.getMimeType(originalFileName);
            log.info("mimeType: " + mimeType);

            // save할 파일이름
            String saveFileName = uuid+"_"+originalFileName;
            File saveFile = new File(path, saveFileName);
            log.info("path: " + path);
            log.info("saveFileName: " + saveFileName);
            
            // 예외처리
            try ( InputStream in = mFile.getInputStream();
                  OutputStream out = new FileOutputStream(saveFile);
            ) {

                // 파일 Copy
                FileCopyUtils.copy(in, out);

                // 이미지 파일일 경우
                if(mimeType.contains("image")) {
                    // 섬네일 생성
                    File thumOutFile = new File(path, "s_" + saveFileName);
                    Thumbnailator.createThumbnail(saveFile, thumOutFile, 200, 200);
                }    

                uploadFileNames.add(saveFileName);
                
            } catch (Exception e) {
                throw new UploadException("Upload Fail: " + e.getMessage());
            }
            
        }
        //이름을 디비에 저장
        BookImageDTO bookImageDTO = new BookImageDTO();
        Long tno = bookMapper.setBook(bookDTO); 
        bookImageDTO.setImage_bno(bookDTO.getBno());
        log.info("=======================================");
        
        int ord = 0;
        for(String uploadFileName : uploadFileNames ){
            bookImageDTO.setImage(uploadFileName);
            bookImageDTO.setOrd(ord++);
            bookMapper.setBookImage(bookImageDTO);
        }
        
        return tno;



    }
    
}
