package org.spring.crud_validaciones.Service;

import org.spring.crud_validaciones.Model.Usuario;
import org.spring.crud_validaciones.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Usuario findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Usuario create(Usuario usuario) {
        if(userRepository.existsById(usuario.getId()) || usuario.getId() != null) {
            usuario.setId(null);
        }
        return userRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        if(userRepository.existsById(usuario.getId())) {
            return userRepository.save(usuario);
        }
        return null;
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
