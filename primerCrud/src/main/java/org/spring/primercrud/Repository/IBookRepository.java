package org.spring.primercrud.Repository;

import org.spring.primercrud.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Libro, String> {
}
