package com.unicine.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

import com.unicine.dto.DetalleFuncionesDTO;
import com.unicine.entidades.Funcion;
import com.unicine.repo.FuncionRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {

    /**
     * NOTE: En las pruebas de unitarias o de integracion se menciona que se debe comprobar el resultado con el Assertions, pero no esta de mas imprimir el resultado para verificar visualmente que se esta obteniendo lo esperado
     */

    @Autowired
    private FuncionRepo funcionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Funcion> funciones = funcionRepo.findAll();

        Assertions.assertEquals(7, funciones.size());

        for (Funcion f : funciones) {
            System.out.println(f);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarDetallesFunciones() {
        List<DetalleFuncionesDTO> detalle = funcionRepo.listarDetallesFunciones(1);

        Assertions.assertEquals(1, detalle.size());

        detalle.forEach(System.out::println);
    } 
}
