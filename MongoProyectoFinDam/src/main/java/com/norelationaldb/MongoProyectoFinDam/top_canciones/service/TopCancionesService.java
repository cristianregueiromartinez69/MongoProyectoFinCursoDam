package com.norelationaldb.MongoProyectoFinDam.top_canciones.service;

import com.norelationaldb.MongoProyectoFinDam.model.entity.TopCanciones;
import com.norelationaldb.MongoProyectoFinDam.repository.TopCancionesRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de top de canciones
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class TopCancionesService {

    //atributos de clase
    private final TopCancionesRepository topCancionesRepository;
    private final MongoTemplate mongoTemplate;

    /**
     * Constructor de la clase
     * @param topCancionesRepository repositorio de canciones
     * @param mongoTemplate mongo template
     */
    public TopCancionesService(TopCancionesRepository topCancionesRepository, MongoTemplate mongoTemplate) {
        this.topCancionesRepository = topCancionesRepository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Metodo para incrementar canciones en el documento de mongo
     * @param idCancion el id de la cancion
     */
    public void incrementVecesEscuchada(Integer idCancion) {
        if(checkIfExistsSongTop(idCancion)) {
            Query query = new Query(Criteria.where("idCancion").is(idCancion));
            Update update = new Update().inc("vecesEscuchada", 1);
            mongoTemplate.updateFirst(query, update, TopCanciones.class);
        }
        else {
            TopCanciones topCanciones = new TopCanciones();
            topCanciones.setIdCancion(idCancion);
            topCanciones.setVecesEscuchada(1);
            topCancionesRepository.save(topCanciones);
        }
    }

    /**
     * Metodo para obtener todas las canciones ordenadas de veces escuchadas en spotify
     * @return la lista de canciones ordenadas
     */
    public List<TopCanciones> getTopCanciones(){
        return topCancionesRepository.findTopCancionesOrdenadas();
    }

    /**
     * Metodo para verificar si existe la cancion para agragar el +1 de veces escuchada
     * @param idCancion el id de la cancion
     * @return true o false dependiendo de si existe o no
     */
    private boolean checkIfExistsSongTop(Integer idCancion){
        TopCanciones topCanciones = topCancionesRepository.findByIdCancion(idCancion);
        return topCanciones != null;
    }


}
