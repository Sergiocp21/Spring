package org.spring.primercrud.Repository;

import org.spring.primercrud.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestamosRepository extends JpaRepository<Prestamo, Integer> {

}
