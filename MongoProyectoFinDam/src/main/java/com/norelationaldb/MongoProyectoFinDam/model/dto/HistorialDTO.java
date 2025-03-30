package com.norelationaldb.MongoProyectoFinDam.model.dto;

public class HistorialDTO {

    private String id;
    private Integer idCancion;
    private String emailUser;

    public HistorialDTO(String id, Integer idCancion, String emailUser) {
        this.id = id;
        this.idCancion = idCancion;
        this.emailUser = emailUser;
    }

    public HistorialDTO(Integer idCancion, String emailUser) {
        this.idCancion = idCancion;
        this.emailUser = emailUser;
    }

    public HistorialDTO() {

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
