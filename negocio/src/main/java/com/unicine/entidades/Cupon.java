package com.unicine.entidades;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
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
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {

    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Lob
    @Column(nullable = false, columnDefinition = "text")
    private String descripcion;

    @Max(100)
    @Positive
    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false, length = 100)
    private String criterio;

    @Column(nullable = false)
    private LocalDateTime fechaVencimiento;

    // SECTION: Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "cupon", cascade =  CascadeType.ALL)
    private List<CuponCliente> cuponClientes;
    
    // SECTION: Constructor

    @Builder
    public Cupon(String descripcion, Double descuento, String criterio, LocalDateTime fechaVencimiento) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.criterio = criterio;
        this.fechaVencimiento = fechaVencimiento;
    }
}
