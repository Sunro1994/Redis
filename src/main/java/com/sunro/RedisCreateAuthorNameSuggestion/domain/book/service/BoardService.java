package com.sunro.RedisCreateAuthorNameSuggestion.domain.book.service;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.book.dto.BoardWriteReq;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.book.entity.Book;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BookRepository bookRepository;

    public Book create(BoardWriteReq boardWriteReq) {

        boolean flag = validateBookTitle(boardWriteReq);
if(flag){
        Book book = Book.builder()
                .title(boardWriteReq.getTitle())
                .description(boardWriteReq.getDescription())
                .likeCount(0)
                .build();

        bookRepository.save(book);


        return book;
}
return null;

    }

    private boolean validateBookTitle(BoardWriteReq boardWriteReq) {
        Optional<Book> findBook =
                bookRepository.findByTitle(boardWriteReq.getTitle());

        if (!findBook.isPresent()) {
            log.info("이미 존재하는 책입니다.");
            return false;
        }

        return true;
    }


    public void likeCountUpOrDown(Long id) {



    }
}
