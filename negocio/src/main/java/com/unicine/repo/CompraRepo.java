package com.unicine.repo;

import com.unicine.dto.DetalleCompraDTO;
import com.unicine.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    // REVIEW: La razón de esta variable es para evitar escribir el nombre completo de la clase en la consulta es inutil para una sola consulta para para varios DTO es util
    String d = "com.unicine.dto";

    // NOTE: En el caso de necesitar conexiones para hacer la consulta como esta donde necesatamos obtener la compras del cliente se puede hacer con join se puede usar en lugar del in, ambos cumplen la misma función, es así como la cláusula anterior
    @Query("select c from Cliente cl join cl.compras c where cl.cedula = :cedula")
    List<Compra> obtenerComprasCedula(Integer cedula);
    
    // NOTE: Tambien se puede usar in para hacer la conexion de las tablas para la consulta, pero el in es mas usado para para poder acceder a los elementos de los atributos de tipo List. Ejemplo, si se desea obtener todos los departamentos de Colombia, para identificar su uso debemos fijarnos en la relación entre las clases si va de uno a muchos en las dos formas
    @Query("select compra from Cliente cliente, in(cliente.compras) compra where cliente.correo = :correo")
    List<Compra> obtenerComprasCorreo(String correo);

    // IMPORTANT: Las consultas no solo se limitan a un elemento, se puede hacer consulta de varios objetos o atributos de la entidad, entonces es necesario cambiar el tipo de retorno de la consulta a Object[], pero a la larga se recomendaría usar DTO(Data Transfer Object) para que sea mas entendible
    @Query("select c, cl.nombre from Cliente cl left join cl.compras c")
    List<Object[]> obtenerComprasClientes();

    @Query("select new " + d + ".DetalleCompraDTO( c.valorTotal, c.fechaCompra, c.funcion.codigo, (select coalesce(sum(e.precio), 0) from Entrada e where e.compra.codigo = c.codigo), (select coalesce(sum(conf.precio * conf.unidades), 0) from CompraConfiteria conf where conf.compra.codigo = c.codigo)) from Compra c where c.cliente.cedula = :cedulaCliente")
    List<DetalleCompraDTO> obtenerInformacionCompra(Integer cedulaCliente);

    @Query("select e.precio from Entrada e where e.compra.codigo = :codigoCompra")
    List<Double> obtenerPreciosEntradaCompra(Integer codigoCompra);

    @Query("select conf.precio * conf.unidades from CompraConfiteria conf where conf.compra.codigo = :codigoCompra")
    List<Double> obtenerPreciosConfiteriaCompra(Integer codigoCompra);
}
