package br.com.ldf.medium.jimmer_demo.service;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.persistence.repository.BookRepository;
import io.github.ice_lfernandes.spring.log.utils.features.annotations.LogExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }

    @LogExecution
    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

}