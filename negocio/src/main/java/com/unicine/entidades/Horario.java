package com.unicine.entidades;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private String hora;

    // NOTE: Revisar utilidad del fetch mode como reemplazo del lazy collection option
    @ElementCollection
    @Fetch(FetchMode.SELECT)
    private List<Dias> dias;


    // SECTION: Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
    private List<Funcion> funciones;
    
    // SECTION: Constructor

    @Builder
    public Horario(LocalDateTime fechaInicio, LocalDateTime fechaFin, String hora) {
        this.fechaInicio = fechaInicio;
        this.hora = hora;
        this.dias = new ArrayList<>();
        this.fechaFin = fechaFin;
    }
}
