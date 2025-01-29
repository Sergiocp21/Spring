package org.spring.primercrud.Controller;

import org.spring.primercrud.Model.Ejemplar;
import org.spring.primercrud.Service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/ejemplar")
public class EjemplarController {
    @Autowired
    EjemplarService ejemplarService;

    @GetMapping
    public ResponseEntity<List<Ejemplar>> getAllUsers() {
        return ResponseEntity.status(200).body(ejemplarService.findAll());
    }

    @GetMapping("/{id}")
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
