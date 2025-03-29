package com.norelationaldb.MongoProyectoFinDam.usuarios.login.controller;

import com.norelationaldb.MongoProyectoFinDam.excepciones.LoginUserExcepcion;
import com.norelationaldb.MongoProyectoFinDam.model.entity.Usuarios;
import com.norelationaldb.MongoProyectoFinDam.usuarios.login.service.LoginUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller de registro de usuarios para mongo
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/MongoProyectoFinDam/spotify")
public class LoginUsuarioRestController {

    //servicio de login de usuarios
    private final LoginUsuarioService loginUsuarioService;

    /**
     * Constructor de la clase
     * @param loginUsuarioService el servicio de login de usuarios
     */
    public LoginUsuarioRestController(LoginUsuarioService loginUsuarioService) {
        this.loginUsuarioService = loginUsuarioService;
    }

    /**
     * metodo post para loguear un usuario
     * @param usuarios el objeto usuarios
     * @return un mensaje indicando si se logueo o no
     */
    @PostMapping("/loginusuarios")
    public ResponseEntity<String> loginUsuariosRestControllerMongo(@RequestBody Usuarios usuarios){
        try {
            if (loginUsuarioService.loginUser(usuarios)) {
                return ResponseEntity.ok("Usuario logueado correctamente ");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }
        } catch (LoginUserExcepcion logE) {
            return new ResponseEntity<>(logE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
