package com.unicine.repo;

import com.unicine.entidades.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CuponRepo extends JpaRepository<Cupon, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    // NOTE: La segunda forma de recibir parametros en una consulta es usando el signo de dos puntos seguido del nombre del parametro, en caso de varios se ponen en orden
    @Query("select distinct c.cupon from CuponCliente c where c.cliente.cedula = :cedula")
    List<Cupon> listarCuponesCliente(Integer cedula);
}
