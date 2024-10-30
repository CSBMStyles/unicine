package com.unicine.repo;

import com.unicine.entidades.EstadoPelicula;
import com.unicine.entidades.Pelicula;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria
/* 
    PeluculaFuncion funciondto = new PeliculaFuncion(p, f);

    @Query("select funciondto from Pelicula p left join p.funciones f where p.nombre like concat('%',:nombre,'%') ")
    List<PeliculaFuncion> buscarPeliculas(String nombre);
 */
    @Query("select p from Pelicula p where p.nombre = :nombrePelicula")
    Optional<Pelicula> obtenerPeliculaNombre(String nombrePelicula);

    @Query("select f.pelicula from Funcion f where  f.codigo = : codigoPelicula")
    Optional<Pelicula> obtenerPeliculaFuncion(Integer codigoPelicula);

    @Query("select f.pelicula.nombre from Funcion f where f.codigo = :codigoFuncion")
    String obtenerNombreFuncion(Integer codigoFuncion);

    @Query("select distinct f.pelicula from Funcion f where f.sala.teatro.ciudad.codigo = :codigoCiudad and f.pelicula.estado = :estadoPelicula")
    List<Pelicula> listarPeliculasCuidadEstado(Integer codigoCiudad, EstadoPelicula estadoPelicula);

    @Query("select distinct f.pelicula from Funcion f where f.pelicula.estado = :estadoPelicula")
    List<Pelicula> listarPeliculasEstado(EstadoPelicula estadoPelicula);
}
