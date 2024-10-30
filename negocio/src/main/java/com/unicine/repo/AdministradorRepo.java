package com.unicine.repo;

import com.unicine.entidades.Administrador;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {
// NOTE: En la creacion del repositorio se extiende de jpa repository, se le pasa la entidad y el tipo de dato de la llave primaria

    @Query("select a from Administrador a where a.correo = :correo and a.password = :password")
    Administrador comprobarAutenticacion(String correo, String password);

    Optional<Administrador> findByCorreo(String correo);
}
