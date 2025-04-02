package com.norelationaldb.MongoProyectoFinDam.repository;

import com.norelationaldb.MongoProyectoFinDam.model.entity.TopCanciones;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de top de canciones
 * @author cristian && Joel
 * @version 1.0
 */
public interface TopCancionesRepository extends MongoRepository<TopCanciones, String> {

    /**
     * Metodo para encontrar un objeto por id de canciones
     * @param idCancion el id de la cancion
     * @return el objeto cancion
     */
    TopCanciones findByIdCancion(Integer idCancion);
}
