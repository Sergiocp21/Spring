package org.spring.primercrud.Repository;

import org.spring.primercrud.Model.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEjemplarRepository extends JpaRepository<Ejemplar, Integer> {
}
