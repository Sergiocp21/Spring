package org.spring.crud_validaciones.Service;

import org.spring.crud_validaciones.Model.Ejemplar;
import org.spring.crud_validaciones.Repository.IEjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemplarService {

    @Autowired
    IEjemplarRepository ejemplarRepository;

    public List<Ejemplar> findAll() {
        return ejemplarRepository.findAll();
    }

    public Ejemplar findById(int id) {
        return ejemplarRepository.findById(id).orElse(null);
    }

    public Ejemplar create(Ejemplar ejemplar) {
        if(ejemplarRepository.existsById(ejemplar.getId()) || ejemplar.getId() != null) {
            ejemplar.setId(null);
        }
        return ejemplarRepository.save(ejemplar);
    }

    public Ejemplar update(Ejemplar ejemplar) {
        if(ejemplarRepository.existsById(ejemplar.getId())) {
            return ejemplarRepository.save(ejemplar);
        }
        return null;
    }

    public void delete(int id) {
        ejemplarRepository.deleteById(id);
    }
}
