package br.com.ldf.medium.jimmer_demo.persistence.entity;

import jakarta.annotation.Nullable;
import org.babyfish.jimmer.sql.*;

import java.util.List;

@Entity
public interface BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    String name();

    @Nullable
    String website();

    @OneToMany(mappedBy = "store")
    List<Book> books();
}