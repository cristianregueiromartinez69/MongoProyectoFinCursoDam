package com.norelationaldb.MongoProyectoFinDam.repository;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Historial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio del historial de canciones guardadas en mongo
 * @author cristian && Joel
 * @version 1.0
 */
@Repository
public interface HistorialRepository extends MongoRepository<Historial, String> {

    @Query(value = "{ 'email' : ?0 }", count = true)
    long countByEmailUser(String email);

    void deleteByIdCancion(Integer idCancion);

    Historial findByIdCancion(Integer idCancion);
}
