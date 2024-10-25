package com.unicine.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.unicine.entidades.Cliente;
import com.unicine.repo.ClienteRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    /**
     * NOTE: En las pruebas de unitarias o de integracion se menciona que se debe comprobar el resultado con el Assertions, pero no esta de mas imprimir el resultado para verificar visualmente que se esta obteniendo lo esperado
     */

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        // Creamos un mapa de imágenes
        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("http://example.com/imagen-1.jpg", "perfil");
        imagenes.put("http://example.com/imagen-2.jpg", "portada");

        // Crear la lista de teléfonos
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3160369165");

        Cliente cliente = new Cliente(1004000066, "Juan", "Parra", "juan@gmail.com", "78!Kz9'Aovr1>`A5", false, imagenes, telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        Assertions.assertEquals("Juan", guardado.getNombre());

        System.out.println(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        // NOTE: El or else es para evitar el <NullPointerException> en caso de no existir
        Cliente guardado = clienteRepo.findById(1009000011).orElse(null);

        System.out.println(guardado);

        guardado.setNombre("Juan");

        Cliente actualizado = clienteRepo.save(guardado);

        Assertions.assertEquals("Juan", actualizado.getNombre());

        System.out.println(actualizado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        Cliente buscado = clienteRepo.findById(1009000011).orElse(null);

        System.out.println(buscado);

        clienteRepo.delete(buscado);

        Cliente verificacion = clienteRepo.findById(1009000011).orElse(null);

        // NOTE: Verificar que el cliente fue eliminado, donde se usar or else para evitar el <NullPointerException>
        Assertions.assertNull(verificacion);

        System.out.println(verificacion);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {

        // NOTE: El Optional es un contenedor que puede o no contener un valor no nulo, esto para evitar el <NullPointerException>
        // REVIEW: Se recomienda usar la primera forma, sin el Optional y mejor aplicar el "orElse" para evitar el <NullPointerException>
        Optional<Cliente> buscado = clienteRepo.findById(1009000011);

        Assertions.assertTrue(buscado.isPresent());

        System.out.println(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Cliente> clientes = clienteRepo.findAll();

        Assertions.assertEquals(5, clientes.size());

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
