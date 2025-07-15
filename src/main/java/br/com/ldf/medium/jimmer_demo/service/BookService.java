package br.com.ldf.medium.jimmer_demo.service;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.persistence.repository.BookNativeSQLRepository;
import br.com.ldf.medium.jimmer_demo.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookNativeSQLRepository bookNativeSQLRepository;
    private final BookRepository bookRepository;

    public Book findById(Long id, boolean nativeQuery) {
        if (nativeQuery) {
            return bookNativeSQLRepository.findById(id);
        }
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByName(String name) {
        return bookNativeSQLRepository.findByName(name);
    }

    public Page<Book> findBooks(int pageIndex, int pageSize, String sortCode, String name) {
        return bookNativeSQLRepository.findBooks(
            pageIndex,
            pageSize,
            null, // No fetcher provided
            sortCode,
            name,
            null, // No minimum price filter
            null, // No maximum price filter
            null, // No store name filter
            null, // No store website filter
            null, // No author name filter
            null  // No author gender filter
        );
    }

}