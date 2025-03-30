package com.norelationaldb.MongoProyectoFinDam.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historial")
public class Historial {

    @Id
    @JsonIgnore
    private String id;

    private Integer idCancion;
    private String emailUser;

    public Historial(String id, Integer idCancion, String emailUser) {
        this.id = id;
        this.idCancion = idCancion;
        this.emailUser = emailUser;
    }

    public Historial(Integer idCancion, String emailUser) {
        this.idCancion = idCancion;
        this.emailUser = emailUser;
    }

    public Historial() {

    }

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

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
