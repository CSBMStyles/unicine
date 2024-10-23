package com.unicine.entidades;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
import java.util.Map;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula implements Serializable {

    // SECTION: Atributos

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private EstadoPelicula estado;

    @ElementCollection
    @Fetch(FetchMode.SELECT)
    private List<GeneroPelicula> generos;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ElementCollection
    private List<String> repartos;

    @Lob
    @Column(nullable = false)
    private String sinopsis;

    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> imagenes;

    @Column(nullable = false)
    private String urlTrailer;

    // REVIEW: Revisar aplicabilidad de precision y scale
    @Max(5)
    @Positive
    //@Column(nullable = false, precision = 1, scale = 2)
    private Double puntuacion;

    // SECTION: Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula", cascade =  CascadeType.ALL)
    private List<Funcion> funciones;
    
    // SECTION: Constructor

    @Builder
    public Pelicula(EstadoPelicula estado, GeneroPelicula accion, Map<String, String> imagenes, String nombre, List<String> listaReparto, List<String> repartos, String sinopsis, String urlTrailer, Double puntuacion) {
        this.estado = estado;
        this.generos = new ArrayList<>();
        this.imagenes = imagenes;
        this.nombre = nombre;
        this.repartos = repartos;
        this.sinopsis = sinopsis;
        this.urlTrailer = urlTrailer;
        this.puntuacion = puntuacion;
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
