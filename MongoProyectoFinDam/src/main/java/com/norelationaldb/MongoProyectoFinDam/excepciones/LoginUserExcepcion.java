package com.norelationaldb.MongoProyectoFinDam.excepciones;

/**
 * Excepcion de login de usuarios
 * @author cristian && joel
 * @version 1.0
 */
public class LoginUserExcepcion extends RuntimeException {
    public LoginUserExcepcion(String message) {
        super(message);
    }
}
