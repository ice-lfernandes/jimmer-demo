package br.com.ldf.medium.jimmer_demo.persistence.repository;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import org.babyfish.jimmer.spring.repository.JRepository;

public interface BookRepository extends JRepository<Book, Long> {

}
