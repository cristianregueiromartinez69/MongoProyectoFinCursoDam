package com.norelationaldb.MongoProyectoFinDam.repository;

import com.norelationaldb.MongoProyectoFinDam.model.entity.TopCanciones;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    /**
     * Metodo que obtiene una lista de canciones de más escuchada a menos
     * @return la lista de canciones
     */
    @Query(value = "{}", sort = "{ 'vecesEscuchada': -1 }")
    List<TopCanciones> findTopCancionesOrdenadas();

}
