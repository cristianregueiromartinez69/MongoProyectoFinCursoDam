package com.norelationaldb.MongoProyectoFinDam.usuarios.registro.service;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import com.norelationaldb.MongoProyectoFinDam.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio para guardar en mongo el usuario
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class RegistroUsuariosService {

    //repositorio de usuarios
    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor de la clase
     * @param usuarioRepository el repositorio de usuarios
     */
    public RegistroUsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Metodo que guarda un usuario en mongo
     * @param usuario el usuario a guardar
     */
    public void saveUsuarioMongo(Usuarios usuario) {
        usuarioRepository.save(usuario);
    }
}
