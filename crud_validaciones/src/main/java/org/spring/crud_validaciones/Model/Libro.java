package org.spring.crud_validaciones.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "El titulo no puede ser nulo")
    @Size(max = 200)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Solo caracteres alfanumericos")
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Solo caracteres alfanumericos")
    private String autor;

    @OneToMany(mappedBy = "isbn")
    @JsonManagedReference("isbnEjemplar")
    private Set<Ejemplar> ejemplares = new LinkedHashSet<>();

}