package org.spring.crud_validaciones.Repository;

import org.spring.crud_validaciones.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Libro, String> {
}
