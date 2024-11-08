package com.unicine.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.unicine.dto.DetalleCompraDTO;
import com.unicine.entidades.Compra;
import com.unicine.repo.CompraRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    /**
     * NOTE: En las pruebas de unitarias o de integracion se menciona que se debe comprobar el resultado con el Assertions, pero no esta de mas imprimir el resultado para verificar visualmente que se esta obteniendo lo esperado
     */

    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasCedula(){

        List<Compra> compras = compraRepo.obtenerComprasCedula(1008000022);

        System.out.println("Resultado: \n");

        for (Compra c : compras) {
            Assertions.assertEquals(1008000022, c.getCliente().getCedula());

            System.out.println(c.getCodigo());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasCorreo(){

        List<Compra> compras = compraRepo.obtenerComprasCorreo("juan@outlook.com");

        System.out.println("Resultado: \n");

        for (Compra c : compras) {
            Assertions.assertEquals("juan@outlook.com", c.getCliente().getCorreo());

            System.out.println(c);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerInformacionCompra() {

    List<DetalleCompraDTO> detallesCompra = compraRepo.obtenerInformacionCompra(1008000022);

    // Verifica que los detalles de la compra sean correctos
    Assertions.assertFalse(detallesCompra.isEmpty(), "No se encontraron detalles de la compra");

    System.out.println("Resultado: \n");
    
    for (DetalleCompraDTO detalle : detallesCompra) {
        System.out.println(detalle);
    }
}

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPreciosEntradaCompra() {
        Integer codigoCompra = 1; // Reemplaza con un código de compra válido para tu dataset

        List<Double> preciosEntrada = compraRepo.obtenerPreciosEntradaCompra(codigoCompra);

        Assertions.assertEquals(1, preciosEntrada.size());

        System.out.println("Resultado: \n");

        System.out.println(preciosEntrada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPreciosConfiteriaCompra() {
        Integer codigoCompra = 1; // Reemplaza con un código de compra válido para tu dataset

        List<Double> preciosConfiteria = compraRepo.obtenerPreciosConfiteriaCompra(codigoCompra);

        Assertions.assertEquals(2, preciosConfiteria.size());

        System.out.println("Resultado: \n");

        System.out.println(preciosConfiteria);
    }
}
