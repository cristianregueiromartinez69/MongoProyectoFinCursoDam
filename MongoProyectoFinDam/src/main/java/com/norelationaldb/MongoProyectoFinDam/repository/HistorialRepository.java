package com.norelationaldb.MongoProyectoFinDam.repository;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Historial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio del historial de canciones guardadas en mongo
 * @author cristian && Joel
 * @version 1.0
 */
@Repository
public interface HistorialRepository extends MongoRepository<Historial, String> {

    /**
     * Metodo que devuelve la cantidad de canciones que tiene un usuario en el historial
     * @param email el email del usuario
     * @return un numero con la cantidad de canciones
     */
    @Query(value = "{ 'email' : ?0 }", count = true)
    long countByEmailUser(String email);

    /**
     * Metodo que borra un objeto historial por id de cancion
     * @param idCancion el id de la cancion a borrar
     */
    void deleteByIdCancion(Integer idCancion);


    /**
     * Metodo que devuelve una cancion de historial por id de cancion
     * @param idCancion el id de la cancion
     * @return el objeto historial
     */
    Historial findByIdCancion(Integer idCancion);

    /**
     * Metodo que devuelve una lista de historial por email
     * @param email el email del usuario logueado
     * @return la lista de historial
     */
    List<Historial> findByEmailUser(String email);

    /**
     * Metodo de borrado de objeto historial por id de cancion e email de usuario
     * @param idCancion el id de la cancion
     * @param email el email del usuario
     */
    void deleteByIdCancionAndEmailUser(Integer idCancion, String email);
}
