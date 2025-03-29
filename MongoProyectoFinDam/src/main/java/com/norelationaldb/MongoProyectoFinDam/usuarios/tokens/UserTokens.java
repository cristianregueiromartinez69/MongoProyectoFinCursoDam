package com.norelationaldb.MongoProyectoFinDam.usuarios.tokens;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Hashmap para guardar el email del usuario logueado al entrar
 * @author cristian && Joel
 * @version 1.0
 */
@Component
public class UserTokens {

    // Mapa concurrente para almacenar tokens de usuarios
    private final ConcurrentHashMap<String, String> userTokens;

    public UserTokens() {
        userTokens = new ConcurrentHashMap<>();
    }

    public void putUserToken(String email, String token) {
        userTokens.put(email, token);
    }

    public String getUserToken(String email) {
        return userTokens.get(email);
    }

    public void removeUserToken(String email) {
        userTokens.remove(email);
    }

    public ConcurrentHashMap<String, String> getUserTokens() {
        return userTokens;
    }
}
