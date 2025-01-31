package org.spring.crud_validaciones.Repository;

import org.spring.crud_validaciones.Model.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEjemplarRepository extends JpaRepository<Ejemplar, Integer> {
}
