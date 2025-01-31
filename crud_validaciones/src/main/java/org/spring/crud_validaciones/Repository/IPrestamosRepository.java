package org.spring.crud_validaciones.Repository;

import org.spring.crud_validaciones.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrestamosRepository extends JpaRepository<Prestamo, Integer> {

}
