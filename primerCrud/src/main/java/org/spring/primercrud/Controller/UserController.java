package org.spring.primercrud.Controller;

import org.spring.primercrud.Model.Usuario;
import org.spring.primercrud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        return ResponseEntity.status(200).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") int id) {
        Usuario user = userService.findById(id);
        if(user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);

    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
        Usuario usr = userService.create(user);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario user) {
        Usuario usr = userService.update(user);
        if(usr != null) {
            return ResponseEntity.status(201).body(usr);
        }
        return ResponseEntity.status(400).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        Usuario user = userService.findById(id);
        if(user != null) {
            userService.delete(id);
            return ResponseEntity.status(200).body("Usuario boorrado");
        }
            return ResponseEntity.status(404).body("Error al borrar al usuario");
    }

}
