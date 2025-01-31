package org.spring.crud_validaciones.Repository;

import org.spring.crud_validaciones.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer> {

}
