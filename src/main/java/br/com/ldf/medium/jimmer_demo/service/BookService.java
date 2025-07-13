package br.com.ldf.medium.jimmer_demo.service;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }

}