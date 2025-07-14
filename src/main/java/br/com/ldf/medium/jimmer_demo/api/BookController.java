package br.com.ldf.medium.jimmer_demo.api;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id, @RequestParam boolean nativeQuery) {
        Book book = bookService.findById(id, nativeQuery);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    public ResponseEntity<Page<Book>> getBooks(
        int pageIndex,
        int pageSize,
        String sortCode,
        String name
    ) {
        Page<Book> books = bookService.findBooks(pageIndex, pageSize, sortCode, name);
        return ResponseEntity.ok(books);
    }
}
