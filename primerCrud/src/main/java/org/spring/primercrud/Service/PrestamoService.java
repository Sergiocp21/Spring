package org.spring.primercrud.Service;

import org.spring.primercrud.Model.Prestamo;
import org.spring.primercrud.Repository.IPrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    
    @Autowired
    IPrestamosRepository prestamoRepository;

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Prestamo findById(int id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    public Prestamo create(Prestamo prestamo) {
        if(prestamoRepository.existsById(prestamo.getId()) || prestamo.getId() != null) {
            prestamo.setId(null);
        }
        return prestamoRepository.save(prestamo);
    }

    public Prestamo update(Prestamo prestamo) {
        if(prestamoRepository.existsById(prestamo.getId())) {
            return prestamoRepository.save(prestamo);
        }
        return null;
    }

    public void delete(int id) {
        prestamoRepository.deleteById(id);
    }
}
