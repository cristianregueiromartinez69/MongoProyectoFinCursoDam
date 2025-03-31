package com.norelationaldb.MongoProyectoFinDam.historial.controller;

import com.norelationaldb.MongoProyectoFinDam.historial.service.HistorialService;
import com.norelationaldb.MongoProyectoFinDam.model.entity.Historial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller de obtencion del historial de canciones
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/MongoProyectoFinDam/spotify")
public class HistorialOtherOperationsRestController {

    //servicio del historial
    private final HistorialService historialService;

    /**
     * Cosntructor de la clase
     * @param historialService el historial de servicio
     */
    public HistorialOtherOperationsRestController(HistorialService historialService) {
        this.historialService = historialService;
    }

    /**
     * Metodo que obtiene todas las canciones del historial
     * @return la lista de historial o null
     */
    @GetMapping("/historial")
    public ResponseEntity<List<Historial>> getHistorialRestController(){
        try{
            List<Historial> historialList = historialService.getHistorialByEmail();
            if(historialList.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(historialList);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Metodo de borrado de cancion por id en historial
     * @param idCancion el id de la cancion a borrar del historial
     * @return un mensaje descriptivo
     */
    @DeleteMapping("/historial/borrar/id/{idCancion}")
    public ResponseEntity<String> borrarHistorial(@PathVariable Integer idCancion){
        try{
            boolean borrado = historialService.deleteHistorialByIDCancionAndEmail(idCancion);
            if(borrado){
                return ResponseEntity.ok("Cancion borrada del historial");
            }
            else{
                return ResponseEntity.noContent().build();
            }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Metodo de borrado del historial completo de un usuario
     * @return un mensaje indicando si se borro o no
     */
    @DeleteMapping("/historial/borrar")
    public ResponseEntity<String> borrarHistorialCompleto(){
        try{
           boolean borradoCompleto = historialService.borradoCompletoHistorial();
           if(borradoCompleto){
               return ResponseEntity.ok("Historial borrado correctamente");
           }
           else{
               return ResponseEntity.noContent().build();
           }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
}
