package com.unicine.servicio;

import java.util.List;

import com.unicine.entidades.Cliente;

import jakarta.validation.Valid;

public interface ClienteServicio {

    // SECTION: Metodos propios

    Cliente login(@Valid String correo, String password) throws Exception;

    Cliente registrar(@Valid Cliente cliente) throws Exception;

    Cliente actualizar(@Valid Cliente cliente) throws Exception;

    void eliminar(@Valid Integer cedula) throws Exception;

    Cliente obtener(@Valid Integer cedula) throws Exception;

    List<Cliente> listar();
}
