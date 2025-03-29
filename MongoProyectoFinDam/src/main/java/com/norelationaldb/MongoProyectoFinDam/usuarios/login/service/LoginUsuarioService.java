package com.norelationaldb.MongoProyectoFinDam.usuarios.login.service;

import com.norelationaldb.MongoProyectoFinDam.excepciones.LoginUserExcepcion;
import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import com.norelationaldb.MongoProyectoFinDam.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio de login de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class LoginUsuarioService {

    //repositorio de usuarios
    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor de la clase
     * @param usuarioRepository el repositorio de usuarios
     */
    public LoginUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Metodo que comprueba si el email o la contraseña existen en la base de datos
     * @param usuarios el objeto login de usuario
     * @return true o false dependiendo de si existe o no
     */
    public boolean loginUser(Usuarios usuarios){
        if(!checkEmailExists(usuarios.getEmail())){
            throw new LoginUserExcepcion("Email no encontrado, vuelve a escribirlo");
        }
        if(!checkPasswordExists(usuarios.getPasswordU())){
            throw new LoginUserExcepcion("Contraseña no encontrada, vuelve a escribirla");
        }
        return true;
    }

    /**
     * Metodo para comprobar si existe un usuario por email en mongo
     * @param email el email a buscar
     * @return true o false dependiendo de si existe o no
     */
    public boolean checkEmailExists(String email) {
        return usuarioRepository.findByEmail(email) != null;
    }

    /**
     * Metodo para comprobar si existe un usuario por contraseña en mongo
     * @param password la password a buscar
     * @return true o false dependiendo de si existe o no
     */
    public boolean checkPasswordExists(String password) {
        return usuarioRepository.findByPasswordU(password) != null;
    }
}
