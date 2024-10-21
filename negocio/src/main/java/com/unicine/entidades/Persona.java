package com.unicine.entidades;



import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
public class Persona {

    @Id
    @Column(length = 10, nullable = false)
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(length = 50, nullable = false)
    private String nombre;
}
