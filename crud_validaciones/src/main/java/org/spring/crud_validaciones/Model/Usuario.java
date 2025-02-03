package org.spring.crud_validaciones.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotBlank
    @NotNull
    @Size(max=100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Solo caracteres alfanumericos")
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "([A-Za-z0-9]{1,50}@gmail.com)")
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 4, max = 12)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Solo caracteres alfanumericos")
    private String password;

    @Lob
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(Normal|Administrador)$")
    private String tipo;

    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("prestamosUsr")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

}