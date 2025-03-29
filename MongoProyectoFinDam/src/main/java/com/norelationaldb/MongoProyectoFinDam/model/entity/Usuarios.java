package com.norelationaldb.MongoProyectoFinDam.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuarios {

    @Id
    private String id;

    //atributos de clase
    private String email;
    private String passwordU;

    /**
     * Contructor de la clase
     * @param email el email del usuario
     * @param passwordU la contraseña del usuario
     */
    public Usuarios(String email, String passwordU) {
        this.email = email;
        this.passwordU = passwordU;
    }

    public Usuarios() {
    }

    //getter y setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

}
