package br.com.ldf.medium.jimmer_demo.persistence.entity;

import jakarta.annotation.Nullable;
import org.babyfish.jimmer.sql.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "book")
public interface Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();
    
    String name();

    int edition();

    BigDecimal price();

    @ManyToMany
    @JoinTable(
        name = "book_author_mapping",
        joinColumnName = "book_id",
        inverseJoinColumnName = "author_id"
    )
    List<Author> authors();

    @ManyToOne
    @Nullable
    BookStore store();
}