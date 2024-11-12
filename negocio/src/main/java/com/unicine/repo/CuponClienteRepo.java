package com.unicine.repo;

import com.unicine.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponClienteRepo extends JpaRepository<CuponCliente, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    /**
     * Consulta para obtener un cupon por su codigo
     * @param atributo: codigo del cupon
     * @return cupon
     */
    @Query("select c from CuponCliente c where c.codigo = :codigoCupon")
    CuponCliente obtenerCuponCodigo(Integer codigoCupon);

    /**
     * Consulta para obtener un cupon de un cliente
     * @param atributos: codigo del cupon, cedula del cliente
     * @return cupon
     */
    @Query("select c from CuponCliente c where c.cupon.codigo = :codigoCupon and c.cliente.cedula = :cedula")
    CuponCliente obtenerCuponCliente(Integer codigoCupon, Integer cedula);
}
