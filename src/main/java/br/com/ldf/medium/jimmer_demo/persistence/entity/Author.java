package br.com.ldf.medium.jimmer_demo.persistence.entity;

import br.com.ldf.medium.jimmer_demo.persistence.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    Gender gender;

    @ManyToMany(mappedBy = "authors")
    List<Book> books;
}