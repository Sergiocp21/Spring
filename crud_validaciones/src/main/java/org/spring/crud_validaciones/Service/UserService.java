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
        if(validDni(usuario.getDni())){
            return userRepository.save(usuario);
        }
        else{
            return null;
        }
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

    private boolean validDni(String dni){
        try{
            int numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
            int resto = numDni%23;

            char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z'};

            return (letras[resto] == dni.charAt(dni.length()-1));
        }catch (NumberFormatException e){
            return false;
        }
    }

}
