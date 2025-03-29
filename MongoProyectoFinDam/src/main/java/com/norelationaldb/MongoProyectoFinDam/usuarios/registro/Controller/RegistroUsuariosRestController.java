package com.norelationaldb.MongoProyectoFinDam.usuarios.registro.Controller;

import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import com.norelationaldb.MongoProyectoFinDam.usuarios.registro.service.RegistroUsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller de registro de usuarios en mongo
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/MongoProyectoFinDam/spotify")
public class RegistroUsuariosRestController {

    //servicio de registro de usuarios
    private final RegistroUsuariosService registroUsuariosService;

    /**
     * Constructor de la clase
     * @param registroUsuariosService el servicio de registro
     */
    public RegistroUsuariosRestController(RegistroUsuariosService registroUsuariosService) {
        this.registroUsuariosService = registroUsuariosService;
    }

    /**
     * Metodo post para guardar el usuario en mongo
     * @param usuarios el usuario a guardar
     * @return un mensaje indicando que se guardó con exito
     */
    @PostMapping("/registrousuarios")
    public ResponseEntity<String> registroUsuariosMongo(@RequestBody Usuarios usuarios){
        try {
            registroUsuariosService.saveUsuarioMongo(usuarios);
            return ResponseEntity.ok("usuario registrado exitosamente");

        }
        catch (Exception e){
            return new ResponseEntity<>("Ups, ha ocurrido un error a la hora de realizar el registro", HttpStatus.BAD_REQUEST);
        }
    }
}
