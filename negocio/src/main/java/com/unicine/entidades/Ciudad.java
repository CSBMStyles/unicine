package com.unicine.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {
    
    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    // SECTION: Relaciones

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Teatro> teatros;

    // SECTION: Constructor

    @Builder
    public Ciudad(String nombre){
        this.nombre = nombre;
        this.teatros = new ArrayList<>();
    }
}
