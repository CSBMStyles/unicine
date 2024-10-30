package com.unicine.test;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

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

        List<Compra> compras = compraRepo.obtenerComprasCedula(1009000011);

        System.out.println("Resultado: \n");

        for (Compra c : compras) {
            Assertions.assertEquals(1009000011, c.getCliente().getCedula());

            System.out.println(c);
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
}
