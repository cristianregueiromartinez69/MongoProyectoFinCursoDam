package com.norelationaldb.MongoProyectoFinDam.usuarios.login.service;

import com.norelationaldb.MongoProyectoFinDam.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public LoginUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean checkEmailExists(String email) {

    }
}
