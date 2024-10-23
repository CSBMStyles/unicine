package com.unicine.entidades;

/* NOTE: La clase Persona funciona como padre para la clase Administrador, AdministradorTeatro, y Cliente. Esta no se refleja como entidad por la estategia aplicada en las hijas para la herencia */

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {

    // SECTION: Atributos

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private Integer cedula;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @NotNull // Validador de campo no nulo
    @Email // Validador de campo tipo email
    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @Column(nullable = false, length = 50)
    @ToString.Exclude
    private String password;

    // SECTION: Constructor

    public Persona(Integer cedula, String nombre, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
}
