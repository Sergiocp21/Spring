package org.spring.crud_validaciones.Controller;


import org.spring.crud_validaciones.Model.Libro;
import org.spring.crud_validaciones.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/libro")
@CacheConfig(cacheNames = {"libro"})
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Libro>> getAllUsers() {
        return ResponseEntity.status(200).body(bookService.findAll());
    }

    @GetMapping("/{isbn}")
    @Cacheable
    public ResponseEntity<Libro> getUserById(@PathVariable("isbn") String isbn) {
        Libro book = bookService.findById(isbn);
        if(book != null) {
            return ResponseEntity.status(200).body(book);
        }
        return ResponseEntity.status(404).body(null);

    }

    @PostMapping
    public ResponseEntity<Libro> createUser(@RequestBody Libro book) {
        Libro usr = bookService.create(book);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @PutMapping
    public ResponseEntity<Libro> updateUser(@RequestBody Libro book) {
        Libro usr = bookService.update(book);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Libro> deleteUser(@PathVariable String isbn) {
        Libro book = bookService.findById(isbn);
        if(book != null) {
            bookService.delete(isbn);
            return ResponseEntity.status(200).body(book);
        }
        return ResponseEntity.status(404).body(null);
    }
}
