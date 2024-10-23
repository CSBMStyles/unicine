package com.unicine.entidades;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
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
import java.util.Map;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {

    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private Float precio;

    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> imagenes;

    // SECTION: Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "confiteria", cascade = CascadeType.ALL)
    private List<CompraConfiteria> compraConfiterias;
    
    // SECTION: Constructor

    @Builder
    public Confiteria(String nombre, Float precio, String urlImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.compraConfiterias =  new ArrayList<>();
    }

    /*
     * Método que retorna la imagen principal de la película
     * @return String url de la imagen principal
     */
    public String getImagenPrincipal(){
        if (!imagenes.isEmpty()){
            String primera = imagenes.keySet().toArray()[0].toString(); // Recorre el mapa de imágenes y obtiene la primera
            return imagenes.get(primera);
        }
        return ""; // En caso de que no haya imágenes
    }
}
