package org.spring.crud_validaciones.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    @Pattern(regexp = "^(97[89]-?)?\\d{1,5}-?\\d{1,7}-?\\d{1,7}-?[\\dX]$\n", message = "El isbn no es valido")
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @OneToMany(mappedBy = "isbn")
    @JsonManagedReference("isbnEjemplar")
    private Set<Ejemplar> ejemplares = new LinkedHashSet<>();

}