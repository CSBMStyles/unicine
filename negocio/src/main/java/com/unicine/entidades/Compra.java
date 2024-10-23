package com.unicine.entidades;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import java.util.ArrayList;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column (nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

    @Column(nullable = false)
    private LocalDateTime fechaPelicula;

    @Positive
    @Column(nullable = false)
    private Float valorTotal;

    // SECTION: Relaciones

    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<CompraConfiteria> compraConfiterias;

    @OneToOne
    private CuponCliente cuponCliente;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcion funcion;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Entrada> entradas;
    
    // SECTION: Constructor

    @Builder
    public Compra(MedioPago medioPago, CuponCliente cuponCliente, Cliente cliente, Funcion funcion) {
        this.medioPago = medioPago;
        this.fechaCompra = LocalDateTime.now();
        this.cuponCliente = cuponCliente;
        this.cliente = cliente;
        this.funcion = funcion;
        this.entradas = new ArrayList<>();
    }
}
