package com.norelationaldb.MongoProyectoFinDam.top_canciones.controller;

import com.norelationaldb.MongoProyectoFinDam.model.entity.TopCanciones;
import com.norelationaldb.MongoProyectoFinDam.top_canciones.service.TopCancionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller de top canciones de la app
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/MongoProyectoFinDam/spotify")
public class TopCancionesRestController {

    //atributos de clase
    private final TopCancionesService topCancionesService;

    /**
     * Constructor de la clase
     * @param topCancionesService el servicio de top canciones
     */
    public TopCancionesRestController(TopCancionesService topCancionesService) {
        this.topCancionesService = topCancionesService;
    }

    /**
     * Metodo Get para obtener todas las canciones más escuchadas de la app
     * @return
     */
    @GetMapping("/topcanciones")
    public ResponseEntity<List<TopCanciones>> getTopCanciones() {
        try{
            List<TopCanciones> topCanciones = topCancionesService.getTopCanciones();
            if (topCanciones != null) {
                return ResponseEntity.ok(topCanciones);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
