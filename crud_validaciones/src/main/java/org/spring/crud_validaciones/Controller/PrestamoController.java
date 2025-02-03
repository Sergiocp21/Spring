package org.spring.crud_validaciones.Controller;

import org.spring.crud_validaciones.Model.Prestamo;
import org.spring.crud_validaciones.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/prestamo")
@CacheConfig(cacheNames = {"prestamo"})
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllUsers() {
        return ResponseEntity.status(200).body(prestamoService.findAll());
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Prestamo> getUserById(@PathVariable("id") int id) {
        Prestamo prestamo = prestamoService.findById(id);
        if(prestamo != null) {
            return ResponseEntity.status(200).body(prestamo);
        }
        return ResponseEntity.status(404).body(null);

    }

    @PostMapping
    public ResponseEntity<Prestamo> createUser(@RequestBody Prestamo prestamo) {
        Prestamo usr = prestamoService.create(prestamo);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @PutMapping
    public ResponseEntity<Prestamo> updateUser(@RequestBody Prestamo prestamo) {
        Prestamo usr = prestamoService.update(prestamo);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        Prestamo prestamo = prestamoService.findById(id);
        if(prestamo != null) {
            prestamoService.delete(id);
            return ResponseEntity.status(200).body("Prestamo creado con exito");
        }
        return ResponseEntity.status(404).body("Error al crear el prestamo");
    }
}
