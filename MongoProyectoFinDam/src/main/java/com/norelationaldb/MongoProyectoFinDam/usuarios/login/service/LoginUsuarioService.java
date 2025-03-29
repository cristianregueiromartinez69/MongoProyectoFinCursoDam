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
        return usuarioRepository.findByEmail(email) != null;
    }

    public boolean checkPasswordExists(String password) {
        return usuarioRepository.findByEmail(password) != null;
    }
}
