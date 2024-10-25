package com.unicine.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Map;

import com.unicine.entidades.Cliente;
import com.unicine.repo.ClienteRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar() {

        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("perfil", "http://example.com/imagen-1.jpg");
        imagenes.put("portada", "http://example.com/imagen-2.jpg");

        // Crear la lista de teléfonos
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3160369165");

        Cliente cliente = new Cliente(1007248160, "Juan", "juan@gmail.com", "78!Kz9'Aovr1>`A5", false, imagenes, telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        Assertions.assertEquals("Juan", guardado.getNombre());
    }

    @Test
    public void actualizar() {
        
        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("perfil", "http://example.com/imagen-1.jpg");
        imagenes.put("portada", "http://example.com/imagen-2.jpg");

        // Crear la lista de teléfonos
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3160369165");

        Cliente cliente = new Cliente(1007248160, "Juan", "juan@gmail.com", "78!Kz9'Aovr1>`A5", false, imagenes, telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        guardado.setNombre("Juanito");

        Cliente actualizado = clienteRepo.save(guardado);

        Assertions.assertEquals("Juanito", actualizado.getNombre());
    }

    @Test
    public void eliminar() {

        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("perfil", "http://example.com/imagen-1.jpg");
        imagenes.put("portada", "http://example.com/imagen-2.jpg");

        // Crear la lista de teléfonos
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3160369165");

        Cliente cliente = new Cliente(1007248160, "Juan", "juan@gmail.com", "78!Kz9'Aovr1>`A5", false, imagenes, telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        clienteRepo.delete(guardado);

        // NOTE: El Optional es un contenedor que puede o no contener un valor no nulo, esto para evitar el <NullPointerException>
        Optional<Cliente> eliminado = clienteRepo.findById(1007248160);

        // NOTE: Verificar que el cliente fue eliminado, donde se usar or else para evitar el <NullPointerException>
        Assertions.assertNull(eliminado.orElse(null));
    }

    @Test
    public void obtener() {

        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("perfil", "http://example.com/imagen-1.jpg");
        imagenes.put("portada", "http://example.com/imagen-2.jpg");

        // Crear la lista de teléfonos
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3160369165");

        Cliente cliente = new Cliente(1007248160, "Juan", "juan@gmail.com", "78!Kz9'Aovr1>`A5", false, imagenes, telefonos);

        clienteRepo.save(cliente);

        // NOTE: El Optional es un contenedor que puede o no contener un valor no nulo, esto para evitar el <NullPointerException>
        Optional<Cliente> buscado = clienteRepo.findById(1007248160);

        System.out.println(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Cliente> clientes = clienteRepo.findAll();

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
