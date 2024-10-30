package com.unicine.repo;

import com.unicine.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    /* DTO */

    // NOTE: En el caso de necesitar conexiones para hacer la consulta como esta donde necesatamos obtener la compras del cliente se puede hacer con join se puede usar en lugar del IN, ambos cumplen la misma función, es así como la cláusula anterior
    @Query("select c from Cliente cl join cl.compras c where cl.cedula = :cedula")
    List<Compra> obtenerComprasCedula(Integer cedula);
    
    // NOTE: Tambien se puede usar in para hacer la conexion de las tablas para la consulta, pero el in es mas usado para para poder acceder a los elementos de los atributos de tipo List. Ejemplo, si se desea obtener todos los departamentos de Colombia, para identificar su uso debemos fijarnos en la relación entre las clases si va de 1 a *
    @Query("select compra from Cliente cliente, in(cliente.compras) compra where cliente.correo = :correo")
    List<Compra> obtenerComprasCorreo(String correo);
}
