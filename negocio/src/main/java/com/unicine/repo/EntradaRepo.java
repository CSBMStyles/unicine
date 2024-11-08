package com.unicine.repo;

import com.unicine.dto.SillasOcupadasDTO;
import com.unicine.entidades.Entrada;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepo extends JpaRepository<Entrada, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    // REVIEW: La razón de esta variable es para evitar escribir el nombre completo de la clase en la consulta es inutil para una sola consulta para para varios DTO es util
    String d = "com.unicine.dto";

    @Query("select e from Compra c join c.entradas e where c.codigo = :codigoCompra")
    List<Entrada> obtenerEntradasCompra(Integer codigoCompra);

    /**
     * Consulta para obtener las sillas ocupadas de una funcion
     * @param codigoFuncion
     * @return codigo, fila y columna de las entradas
     */
    @Query("select new " + d + ".SillasOcupadasDTO(e.codigo, e.fila, e.columna ) from Compra comp join comp.entradas e join comp.funcion f where f.codigo = :codigoFuncion")
    List<SillasOcupadasDTO> obtenerSillasOcupadas(Integer codigoFuncion);
}
