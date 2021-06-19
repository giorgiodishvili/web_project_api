package com.project.bookstore.service;

import com.project.bookstore.entity.Book;
import com.project.bookstore.exception.BookNotFoundException;
import com.project.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks(){
        return bookRepository.findAllByOrderByName();
    }

    public Book getBook(Long id){
        Optional<Book> result = bookRepository.findById(Math.toIntExact(id));
        return result.orElseThrow(BookNotFoundException::new);
    }

    public Book saveBook(Book book){
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(int id,Book book){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException();
        }
        book.setId(id);
       return bookRepository.save(book);
    }



    public Book deleteBookById(@Min(1) Long id){
        if(!bookRepository.existsById(Math.toIntExact(id))){
            throw new BookNotFoundException();
        }
        Book book = getBook(id);
        bookRepository.deleteById(Math.toIntExact(id));
        return book;
    }

    public List<Book> searchByNameAuthorPublisher(String theFirstName,String author,String publisher) {
        return bookRepository.
                findByNameLikeOrPublisherLikeOrAuthorLikeIgnoreCase(theFirstName,author,publisher
                        );
    }

    public List<Book> searchByName(String theFirstName) {
        List<Book> byNameOrderByName = bookRepository.findByNameOrderByName(theFirstName);

        return byNameOrderByName;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> byAuthorOrderByName = bookRepository.findByAuthorOrderByName(author);
        return byAuthorOrderByName;
    }

    public List<Book> searchByPublisher(String publisher) {
        return bookRepository.findByPublisherOrderByName(publisher);
    }

}
