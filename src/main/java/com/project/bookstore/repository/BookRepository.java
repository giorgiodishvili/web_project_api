package com.project.bookstore.repository;

import com.project.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer> {

    List<Book> findByNameLikeOrPublisherLikeOrAuthorLikeIgnoreCase(
     String name, String author, String publisher);
    List<Book> findAllByOrderByName();
    List<Book> findByNameOrderByName(String name);
    List<Book> findByAuthorOrderByName(String name);
    List<Book> findByPublisherOrderByName(String name);

}
