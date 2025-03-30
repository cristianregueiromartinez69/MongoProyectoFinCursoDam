package com.norelationaldb.MongoProyectoFinDam.model.dto;

import java.time.LocalDate;

public class UsuariosDTO {

    private String id;
    //variables de la clase
    private String username;
    private String email;
    private String passwordU;
    private LocalDate dateReg;

    public UsuariosDTO(String id, String username, String email, String passwordU, LocalDate dateReg) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordU = passwordU;
        this.dateReg = dateReg;
    }

    public UsuariosDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public LocalDate getDateReg() {
        return dateReg;
    }

    public void setDateReg(LocalDate dateReg) {
        this.dateReg = dateReg;
    }
}
