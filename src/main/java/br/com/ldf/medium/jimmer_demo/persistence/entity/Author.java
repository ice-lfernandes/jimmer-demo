package br.com.ldf.medium.jimmer_demo.persistence.entity;

import br.com.ldf.medium.jimmer_demo.persistence.enums.Gender;
import org.babyfish.jimmer.sql.*;

import java.util.List;

@Entity
@Table(name = "author")
public interface Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();
    
    String firstName();

    String lastName();

    Gender gender();

    @ManyToMany(mappedBy = "authors")
    List<Book> books();
}