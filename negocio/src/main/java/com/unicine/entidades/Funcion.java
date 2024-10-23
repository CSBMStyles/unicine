package com.unicine.entidades;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcion implements Serializable {

    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Positive
    @Column(nullable = false)
    private Float precio;

    // SECTION: Relaciones

    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Pelicula pelicula;

    @ToString.Exclude
    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<Compra> compras;
    
    // SECTION: Constructor

    @Builder
    public Funcion(Float precio, Sala sala, Horario horario, Pelicula pelicula) {
        this.precio = precio;
        this.sala = sala;
        this.horario = horario;
        this.pelicula = pelicula;
    }
}
