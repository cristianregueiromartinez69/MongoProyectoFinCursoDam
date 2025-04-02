package com.norelationaldb.MongoProyectoFinDam.top_canciones.service;

import com.norelationaldb.MongoProyectoFinDam.model.entity.TopCanciones;
import com.norelationaldb.MongoProyectoFinDam.repository.TopCancionesRepository;
import org.springframework.stereotype.Service;

@Service
public class TopCancionesService {

    private final TopCancionesRepository topCancionesRepository;

    public TopCancionesService(TopCancionesRepository topCancionesRepository) {
        this.topCancionesRepository = topCancionesRepository;
    }

    private boolean checkIfExistsSongTop(Integer idCancion){
        TopCanciones topCanciones = topCancionesRepository.
    }
}
