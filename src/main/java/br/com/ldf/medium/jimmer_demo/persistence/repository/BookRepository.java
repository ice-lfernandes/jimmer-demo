package br.com.ldf.medium.jimmer_demo.persistence.repository;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import br.com.ldf.medium.jimmer_demo.persistence.entity.BookTable;
import br.com.ldf.medium.jimmer_demo.persistence.enums.Gender;
import io.github.ice_lfernandes.spring.log.utils.features.annotations.LogExecution;
import jakarta.annotation.Nullable;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.query.Order;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class BookRepository {

    private static final BookTable T = BookTable.$;

    private final JSqlClient sqlClient;

    public BookRepository(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @LogExecution
    public Book findById(Long id) {
        return sqlClient
            .createQuery(T)
            .where(T.id().eq(id))
            .select(T)
            .fetchOne();
    }

    public Page<Book> findBooks(
        int pageIndex, // Starts from 0
        int pageSize,

        @Nullable Fetcher<Book> fetcher,

        // e.g. "name asc, edition desc"
        @Nullable String sortCode,

        @Nullable String name,
        @Nullable BigDecimal minPrice,
        @Nullable BigDecimal maxPrice,
        @Nullable String storeName,
        @Nullable String storeWebsite,
        @Nullable String authorName,
        @Nullable Gender authorGender
    ) {
        return sqlClient
            .createQuery(T)
            .where(T.name().ilikeIf(name)) // Case-insensitive like search, e.g. "Harry Potter"
            .where(T.price().betweenIf(minPrice, maxPrice)) // Price range filter, e.g. 20.00 to 50.00
            .where(T.store().name().ilikeIf(storeName)) // Filter by store name, e.g. "Bookstore A"
            .where(T.store().website().ilikeIf(storeWebsite)) // Filter by store website, e.g. "example.com"
            .where( // Filter by author name, e.g. "J.K. Rowling"
                T.authors(author ->
                    Predicate.or(
                        author.firstName().ilikeIf(authorName),
                        author.lastName().ilikeIf(authorName)
                    )
                )
            )
            .where(T.authors(author -> author.gender().eqIf(authorGender)))
            .orderBy(
                Order.makeOrders(
                    T,
                    sortCode != null ?
                        sortCode :
                        "name asc, edition desc"
                )
            )
            .select(
                T.fetch(fetcher) // Use the provided fetcher to control which fields to load
            )
            .fetchPage(pageIndex, pageSize); // Fetch the specified page of results
    }
}