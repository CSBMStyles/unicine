package com.unicine.servicio;

import java.util.List;

import com.unicine.entidades.Administrador;

public interface AdministradorServicio {

    // SECTION: Metodos propios

    Administrador login(String correo, String password) throws Exception;

    Administrador registrar(Administrador cliente) throws Exception;

    Administrador actualizar(Administrador cliente) throws Exception;

    void eliminar(Integer cedula) throws Exception;

    Administrador obtener(Integer cedula) throws Exception;

    List<Administrador> listar();
}
