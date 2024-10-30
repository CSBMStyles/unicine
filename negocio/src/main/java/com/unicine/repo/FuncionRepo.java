package com.unicine.repo;

import com.unicine.entidades.Funcion;
import com.unicine.entidades.Horario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    @Query("select f from Sala s join s.funciones f where s.codigo = :codigoSala and f.horario = :horario")
    List<Funcion> obtenerFuncionesHorarioSala(Integer codigoSala, Horario horario);

    @Query("select f from Funcion f where f.sala.codigo = :codigoSala")
    List<Funcion> listarFuncionesSala(Integer codigoSala);

    @Query("select f from Funcion f where f.sala.teatro.codigo = :codigoTeatro")
    List<Funcion> listarFuncionesTeatro(Integer codigoTeatro);

    @Query("select f from Funcion f where f.sala.teatro.ciudad.codigo = :codigoCiudad")
    List<Funcion> listarFuncionesCiudad(Integer codigoCiudad);

    @Query("select f from Funcion f where f.sala.distribucionSilla.filas = :fila and f.sala.distribucionSilla.columnas = :columna")
    Optional<Funcion> verificarDisponibilidadSillas(Integer fila, Integer columna);

    @Query("select f from Funcion f where f.horario.codigo = :codigo")
    Funcion verificarDisponibilidad(Integer codigo);


}
