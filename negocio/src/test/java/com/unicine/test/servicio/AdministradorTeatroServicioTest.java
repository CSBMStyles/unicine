package com.unicine.test.servicio;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.unicine.entidades.AdministradorTeatro;
import com.unicine.servicio.AdministradorTeatroServicio;

// IMPORTANT: El @Transactional se utiliza para que las pruebas no afecten la base de datos, es decir, que no se guarden los cambios realizados en las pruebas

@SpringBootTest
@Transactional
public class AdministradorTeatroServicioTest {

    @Autowired
    private AdministradorTeatroServicio administradorTeatroServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void login() {

        try {
            AdministradorTeatro administrador = administradorTeatroServicio.login("jhona.belloc@uqvirtual.edu.co", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N");

            Assertions.assertEquals("jhona.belloc@uqvirtual.edu.co", administrador.getCorreo());

            System.out.println("\n" + "Administrador de teatro encontrado:" + "\n" + administrador);

        } catch (Exception e) {
            Assertions.assertTrue(false);

            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        AdministradorTeatro administrador = new AdministradorTeatro(1773000000, "Mariana", "Carta", "mariana@gmail.com", "78!Kz9'Aovr1>`A5");

        try {
            AdministradorTeatro nuevo = administradorTeatroServicio.registrar(administrador);
            
            Assertions.assertEquals(1773000000, nuevo.getCedula());

            System.out.println("\n" + "Registro guardado:" + "\n" + nuevo);

        } catch (Exception e) {
            Assertions.assertTrue(false);

            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        try{
            AdministradorTeatro administrador = administradorTeatroServicio.obtener(1119000000);

            administrador.setNombre("Daniela");

            AdministradorTeatro actualizado = administradorTeatroServicio.actualizar(administrador);

            Assertions.assertEquals("Daniela", actualizado.getNombre());

            System.out.println("\n" + "Registro actualizado:" + "\n" + actualizado);

        } catch (Exception e) {
            Assertions.assertTrue(false);

            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {
        
        try {
            administradorTeatroServicio.eliminar(1119000000);

        } catch (Exception e) {
            Assertions.assertTrue(false);

            throw new RuntimeException(e);
        }
        try {
            administradorTeatroServicio.obtener(1119000000);

        } catch (Exception e) {
            // Realizamos una validacion de la prueba para aceptar que el administrador fue eliminado mendiante la excepcion del metodo de obtener
            Assertions.assertThrows(Exception.class, () -> {
                throw e;
            });

            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {

        try {
            AdministradorTeatro administrador = administradorTeatroServicio.obtener(1119000000);

            Assertions.assertEquals(1119000000, administrador.getCedula());

            System.out.println("\n" + "Registro encontrado:" + "\n" + administrador);

        } catch (Exception e) {
            Assertions.assertTrue(false);

            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        try {
            List<AdministradorTeatro> lista = administradorTeatroServicio.listar();

            Assertions.assertEquals(6, lista.size());

            System.out.println("\n" + "Listado de registros:");

            lista.forEach(System.out::println);

        } catch (Exception e) {
            Assertions.assertTrue(false);

            throw new RuntimeException(e);
        }
    }
}
