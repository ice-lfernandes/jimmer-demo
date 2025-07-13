package br.com.ldf.medium.jimmer_demo.persistence.repository;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}