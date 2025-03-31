package com.norelationaldb.MongoProyectoFinDam.historial.service;

import com.norelationaldb.MongoProyectoFinDam.excepciones.LoginUserExcepcion;
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

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Servicio de logica de historial
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class HistorialService {

    //atributos de clase
    private final HistorialRepository historialRepository;
    private final UserTokens userTokens;
    private final UsuarioRepository usuarioRepository;

    private final MongoTemplate mongoTemplate;

    /**
     * Constructor de la clase
     * @param historialRepository el repositorio del historial
     * @param userTokens el hashmap de users logueados
     * @param usuarioRepository el repositorio de usuarios
     * @param mongoTemplate el mongo template de querys
     */
    public HistorialService(HistorialRepository historialRepository, UserTokens userTokens, UsuarioRepository usuarioRepository, MongoTemplate mongoTemplate) {
        this.historialRepository = historialRepository;
        this.userTokens = userTokens;
        this.usuarioRepository = usuarioRepository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Metodo principal para guardar una cancion
     * @param idCancion el id de la cancion escuchada
     */
    public boolean saveSongHistorial(Integer idCancion){
        String email = getCurrentEmail(userTokens.getUserTokens());
        if(email == null){
            throw new LoginUserExcepcion("Usuario no logueado, fuera hacker!!");
        }
        if(checkIfExistsSongHistorial(idCancion)){
            if(checkLimitSongsHistorial(email)){
                Historial historial = new Historial();
                historial.setIdCancion(idCancion);
                historial.setEmailUser(email);
                historial.setFechaRegistro(LocalDate.now());
                historialRepository.save(historial);
            }
            else{
                Historial historialViejo = getOldHistorial(email);
                historialRepository.deleteByIdCancion(historialViejo.getIdCancion());
                Historial historialNuevo = new Historial();
                historialNuevo.setIdCancion(idCancion);
                historialNuevo.setEmailUser(email);
                historialNuevo.setFechaRegistro(LocalDate.now());
                historialRepository.save(historialNuevo);
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo para devolver una lista de historial de canciones por email de usuario
     * @return la lista de objetos historial
     */
    public List<Historial> getHistorialByEmail(){
        String email = getCurrentEmail(userTokens.getUserTokens());
        if(email == null){
            throw new LoginUserExcepcion("Usuario no logueado, fuera hacker!!");
        }
        return historialRepository.findByEmailUser(email);
    }

    /**
     * Metodo de borrado de una cancion del historial por id de cancion e email
     * @param idCancion el id de la cancion
     * @return un true o false dependiendo de si se borró o no se borró la cancion
     */
    public boolean deleteHistorialByIDCancionAndEmail(Integer idCancion){
        String email = getCurrentEmail(userTokens.getUserTokens());
        if(email == null){
            throw new LoginUserExcepcion("Usuario no logueado, fuera hacker!!");
        }
        Historial historial = historialRepository.findByEmailUserAndIdCancion(email, idCancion);
        if(historial != null){
            historialRepository.deleteByIdCancionAndEmailUser(idCancion, email);
            return true;
        }
        return false;
    }



    /**
     * Metodo para obtener un objeto historial antiguo
     * @param email el email del usuario logueado
     * @return el historial
     */
    private Historial getOldHistorial(String email) {
        if(!checkLimitSongsHistorial(email)) {
            Query query = new Query(Criteria.where("email").is(email));
            query.with(Sort.by(Sort.Direction.ASC, "fechaRegistro"));
            query.limit(1);

            return mongoTemplate.findOne(query, Historial.class);
        }
        return null;
    }

    /**
     * Metodo para saber si ya existe o no esta cancion en el historial
     * @param idCancion el id de la cancion
     * @return true o false dependiendo de si existe o no
     */
    private boolean checkIfExistsSongHistorial(Integer idCancion) {
        Historial historialExistente = historialRepository.findByIdCancion(idCancion);
        return historialExistente == null;
    }

    /**
     * Metodo para saber el numero de canciones del historial
     * @param email el email del usuario logueafo
     * @return true o false dependiendo de si tienes mas de 10 0 menos
     */
    private boolean checkLimitSongsHistorial(String email){
        long numero = historialRepository.countByEmailUser(email);
        return numero <= 10;
    }

    /**
     * Metodo que devuelve el email del usuario logueado
     * @param logginUsers El hashmap con los users logueados
     * @return el email o null
     */
    private String getCurrentEmail(ConcurrentHashMap<String, String> logginUsers){
        for(String usuario : logginUsers.keySet()){
            Usuarios userAuthenticator = usuarioRepository.findByEmail(usuario);
            if(userAuthenticator != null){
                return userAuthenticator.getEmail();
            }
        }
        return null;
    }
}
