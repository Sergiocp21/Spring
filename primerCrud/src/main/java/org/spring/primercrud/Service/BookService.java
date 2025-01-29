package org.spring.primercrud.Service;

import org.spring.primercrud.Model.Libro;
import org.spring.primercrud.Repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    IBookRepository bookRepository;

    public List<Libro> findAll() {
        return bookRepository.findAll();
    }

    public Libro findById(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    public Libro create(Libro book) {
        if(bookRepository.existsById(book.getIsbn())) {
            return null;
        }
        return bookRepository.save(book);
    }

    public Libro update(Libro book) {
        if(bookRepository.existsById(book.getIsbn())) {
            return bookRepository.save(book);
        }
        return null;
    }

    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
