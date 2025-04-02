package com.norelationaldb.MongoProyectoFinDam.repository;

import com.norelationaldb.MongoProyectoFinDam.model.entity.TopCanciones;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopCancionesRepository extends MongoRepository<TopCanciones, String> {


}
