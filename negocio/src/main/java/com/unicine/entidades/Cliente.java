package com.unicine.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente extends Persona implements Serializable {

    // SECTION: Atributos

    @Column(nullable = false)
    private Boolean estado;

    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> imagenes;

    @ElementCollection
    private List<String> telefonos;

    // SECTION: Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> compras;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CuponCliente> cuponClientes;

    // SECTION: Constructor

    @Builder
    public Cliente(Integer cedula, String nombre, String correo, String password, Boolean estado, Map<String, String> imagenes, List<String> telefonos) {
        super(cedula, nombre, correo, password);
        this.estado = false;
        this.imagenes = imagenes;
        this.telefonos = telefonos;
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