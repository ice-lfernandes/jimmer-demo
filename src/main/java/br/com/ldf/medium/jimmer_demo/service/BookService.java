package br.com.ldf.medium.jimmer_demo.service;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final JSqlClient sqlClient;

    public Page<Book> findBooks(int pageIndex, int pageSize, String sortCode, String name) {
        return bookRepository.findBooks(
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