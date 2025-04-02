package com.norelationaldb.MongoProyectoFinDam.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Documento de top canciones escuchadas
 * @author cristian && Joel
 * @version 1.0
 */
@Document(collection = "top_canciones")
public class TopCanciones {

    //atributos de clase
    @Id
    private String id;
    private Integer idCancion;
    private Integer vecesEscuchada;

    /**
     * Cosntructor de la clase
     * @param id clave primaria
     * @param idCancion el id de la cancion
     * @param vecesEscuchada las veces que ha sido escuchada
     */
    public TopCanciones(String id, Integer idCancion, Integer vecesEscuchada) {
        this.id = id;
        this.idCancion = idCancion;
        this.vecesEscuchada = vecesEscuchada;
    }

    public TopCanciones(Integer idCancion, Integer vecesEscuchada) {
        this.idCancion = idCancion;
        this.vecesEscuchada = vecesEscuchada;
    }

    public TopCanciones() {
    }

    //getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Integer getVecesEscuchada() {
        return vecesEscuchada;
    }

    public void setVecesEscuchada(Integer vecesEscuchada) {
        this.vecesEscuchada = vecesEscuchada;
    }
}
