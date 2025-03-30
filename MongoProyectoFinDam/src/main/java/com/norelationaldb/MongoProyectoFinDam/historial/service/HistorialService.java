package com.norelationaldb.MongoProyectoFinDam.historial.service;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import com.norelationaldb.MongoProyectoFinDam.repository.HistorialRepository;
import com.norelationaldb.MongoProyectoFinDam.repository.UsuarioRepository;
import com.norelationaldb.MongoProyectoFinDam.usuarios.tokens.UserTokens;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;
    private final UserTokens userTokens;
    private final UsuarioRepository usuarioRepository;

    public HistorialService(HistorialRepository historialRepository, UserTokens userTokens, UsuarioRepository usuarioRepository) {
        this.historialRepository = historialRepository;
        this.userTokens = userTokens;
        this.usuarioRepository = usuarioRepository;
    }


    public boolean checkLimitSongsHistorial(String email){
        long numero = historialRepository.countByEmailUser(email);
        return numero <= 10;
    }

    /**
     * Metodo que devuelve el email del usuario logueado
     * @param logginUsers El hashmap con los users logueados
     * @return el email o null
     */
    public String getCurrentEmail(ConcurrentHashMap<String, String> logginUsers){
        for(String usuario : logginUsers.keySet()){
            Usuarios userAuthenticator = usuarioRepository.findByEmail(usuario);
            if(userAuthenticator != null){
                return userAuthenticator.getEmail();
            }
        }
        return null;
    }
}
