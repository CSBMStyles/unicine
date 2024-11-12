package com.unicine.repo;

import com.unicine.entidades.Horario;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    @Query("select p.nombre, f.codigo, h from Funcion f join f.horario h join f.pelicula p where p.codigo = :codigoPelicula and function('DATE', h.fechaInicio) = :fecha")
    List<Object[]> obtenerPeliculaFecha(Integer codigoPelicula, LocalDate fecha);
}
