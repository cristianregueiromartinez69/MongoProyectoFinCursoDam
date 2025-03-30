package com.norelationaldb.MongoProyectoFinDam.historial.service;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Historial;
import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import com.norelationaldb.MongoProyectoFinDam.repository.HistorialRepository;
import com.norelationaldb.MongoProyectoFinDam.repository.UsuarioRepository;
import com.norelationaldb.MongoProyectoFinDam.usuarios.tokens.UserTokens;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;
    private final UserTokens userTokens;
    private final UsuarioRepository usuarioRepository;

    private final MongoTemplate mongoTemplate;

    public HistorialService(HistorialRepository historialRepository, UserTokens userTokens, UsuarioRepository usuarioRepository, MongoTemplate mongoTemplate) {
        this.historialRepository = historialRepository;
        this.userTokens = userTokens;
        this.usuarioRepository = usuarioRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Historial getOldHistorial(String email) {
        if(!checkLimitSongsHistorial(email)) {
            Query query = new Query(Criteria.where("email").is(email));
            query.with(Sort.by(Sort.Direction.ASC, "fechaRegistro"));
            query.limit(1);

            return mongoTemplate.findOne(query, Historial.class);
        }
        return null;
    }

    private boolean checkLimitSongsHistorial(String email){
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
