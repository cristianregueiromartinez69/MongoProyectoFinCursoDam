package com.norelationaldb.MongoProyectoFinDam.historial.controller;

import com.norelationaldb.MongoProyectoFinDam.historial.service.HistorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller de guardado de canciones en el historial
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/MongoProyectoFinDam/spotify/canciones")
public class HistorialSaveCancionRestController {

    //servicio del historial
    private final HistorialService historialService;

    /**
     * Constructor de la clase
     * @param historialService el servicio del historial
     */
    public HistorialSaveCancionRestController(HistorialService historialService) {
        this.historialService = historialService;
    }

    /**
     * Metodo post para guardar una cancion en el historial
     * @param idCancion el id de la cancion
     * @return un mensaje descriptivo
     */
    @PostMapping("/play/id/{idCancion}")
    public ResponseEntity<String> saveCancionHistorial(@PathVariable Integer idCancion) {
        try{
            boolean historialGuardado = historialService.saveSongHistorial(idCancion);
            if(historialGuardado){
                return ResponseEntity.ok("cancion añadida al historial");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Sin cambios en el historial");
    }
}
