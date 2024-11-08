package com.unicine.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unicine.entidades.Pelicula;
import com.unicine.repo.PeliculaRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {

    /**
     * NOTE: En las pruebas de unitarias o de integracion se menciona que se debe comprobar el resultado con el Assertions, pero no esta de mas imprimir el resultado para verificar visualmente que se esta obteniendo lo esperado
     */

    @Autowired
    private PeliculaRepo peliculaRepo;

    private static final Logger logger = LoggerFactory.getLogger(PeliculaTest.class);

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Pelicula> peliculas = peliculaRepo.findAll();

        Assertions.assertEquals(5, peliculas.size());

        // NOTE: En este caso se usa el logger para imprimir el resultado ya que si se usar el sout para mostrarlo omite las tildes y caracteres especiales usando el ? en lugar de la letra, cuando se muestrs en la consola debug
        for (Pelicula c : peliculas) {
            logger.info("Pelicula: {}", c);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNombreFuncion(){
 
        String nombrePelicula = peliculaRepo.obtenerNombreFuncion(2);

        Assertions.assertEquals("Dragon Ball: Super Hero", nombrePelicula);

        System.out.println("Nombre de la pelicula: " + nombrePelicula);
    }


    
}
