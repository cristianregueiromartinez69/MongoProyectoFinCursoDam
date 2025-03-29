package com.norelationaldb.MongoProyectoFinDam.repository;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de mongo para comunicarse con la base de datos para usuarios
 * @author cristian && Joel
 * @version 1.0
 */
public interface UsuarioRepository extends MongoRepository<Usuarios, String> {

    //encontrar usuario por email
    Usuarios findByEmail(String email);

    //encontrar usuario por password
    Usuarios findByPasswordU(String nombre);
}
