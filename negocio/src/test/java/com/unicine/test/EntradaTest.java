package com.unicine.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

import com.unicine.dto.SillasOcupadasDTO;
import com.unicine.repo.EntradaRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EntradaTest {

    /**
     * NOTE: En las pruebas de unitarias o de integracion se menciona que se debe comprobar el resultado con el Assertions, pero no esta de mas imprimir el resultado para verificar visualmente que se esta obteniendo lo esperado
     */

    @Autowired
    private EntradaRepo entradaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerSillasOcupadas() {
        List<SillasOcupadasDTO> sillas = entradaRepo.obtenerSillasOcupadas(2);

        Assertions.assertEquals(1, sillas.size());

        System.out.println("Resultado: \n");

        sillas.forEach(System.out::println);
    } 
}
