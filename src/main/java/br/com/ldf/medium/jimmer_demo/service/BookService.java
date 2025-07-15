package br.com.ldf.medium.jimmer_demo.service;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.persistence.repository.BookRepository;
import io.github.ice_lfernandes.spring.log.utils.features.annotations.LogExecution;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }

    public List<Book> findByName(String name) {
        long start = System.nanoTime();
        var books = bookRepository.findByName(name);
        long timeElapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);

        log.info("findByName took {} ms", timeElapsed);
        return books;
    }

}