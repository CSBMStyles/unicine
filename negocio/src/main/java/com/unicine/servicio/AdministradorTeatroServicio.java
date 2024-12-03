package com.unicine.servicio;

import java.util.List;

import com.unicine.entidades.AdministradorTeatro;

public interface AdministradorTeatroServicio {

    // SECTION: Metodos propios

    AdministradorTeatro login(String correo, String password) throws Exception;

    AdministradorTeatro registrar(AdministradorTeatro cliente) throws Exception;

    AdministradorTeatro actualizar(AdministradorTeatro cliente) throws Exception;

    void eliminar(Integer cedula) throws Exception;

    AdministradorTeatro obtener(Integer cedula) throws Exception;

    List<AdministradorTeatro> listar();
}
