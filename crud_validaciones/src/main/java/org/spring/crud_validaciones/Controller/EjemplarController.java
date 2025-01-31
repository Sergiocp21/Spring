package org.spring.crud_validaciones.Controller;

import org.spring.crud_validaciones.Model.Ejemplar;
import org.spring.crud_validaciones.Service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/ejemplar")
@CacheConfig(cacheNames = {"ejemplar"})
public class EjemplarController {
    @Autowired
    EjemplarService ejemplarService;

    @GetMapping
    public ResponseEntity<List<Ejemplar>> getAllUsers() {
        return ResponseEntity.status(200).body(ejemplarService.findAll());
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Ejemplar> getUserById(@PathVariable("id") int id) {
        Ejemplar ejemplar = ejemplarService.findById(id);
        if(ejemplar != null) {
            return ResponseEntity.status(200).body(ejemplar);
        }
        return ResponseEntity.status(404).body(null);

    }

    @PostMapping
    public ResponseEntity<Ejemplar> createUser(@RequestBody Ejemplar ejemplar) {
        Ejemplar usr = ejemplarService.create(ejemplar);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @PutMapping
    public ResponseEntity<Ejemplar> updateUser(@RequestBody Ejemplar ejemplar) {
        Ejemplar usr = ejemplarService.update(ejemplar);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ejemplar> deleteUser(@PathVariable int id) {
        Ejemplar ejemplar = ejemplarService.findById(id);
        if(ejemplar != null) {
            ejemplarService.delete(id);
            return ResponseEntity.status(200).body(ejemplar);
        }
        return ResponseEntity.status(404).body(null);
    }
}
