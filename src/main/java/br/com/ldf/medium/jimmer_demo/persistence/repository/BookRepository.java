package br.com.ldf.medium.jimmer_demo.persistence.repository;

import br.com.ldf.medium.jimmer_demo.persistence.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(nativeQuery = true,
        value = "SELECT * FROM book WHERE name like %?1%")
    List<Book> findByName(String name);

}