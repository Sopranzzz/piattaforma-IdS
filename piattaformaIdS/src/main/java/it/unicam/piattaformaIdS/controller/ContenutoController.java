package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.richieste.ApprovaItinerarioRequest;
import it.unicam.piattaformaIdS.richieste.ApprovaPoiRequest;
import it.unicam.piattaformaIdS.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContenutoController {

    @Autowired
    private ContenutoService contenutoService;

    @PutMapping("/approvaPOI")
    public ResponseEntity<Object> approvaPOI(@RequestBody ApprovaPoiRequest request) {
        try {
            this.contenutoService.approvaPOI(request.getPoiId(), request.getUserId());
            return ResponseEntity.ok().body("Il POI è stato approvato.");
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Non hai i permessi per approvare il POI.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato.");
        }
    }

    @PutMapping("/approvaItinerario")
    public ResponseEntity<Object> approvaItinerario(@RequestBody ApprovaItinerarioRequest request) {
        try {
            this.contenutoService.approvaItinerario(request.getItinerarioId(), request.getUserId());
            return ResponseEntity.ok().body("L'itinerario è stato approvato.");
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Non hai i permessi per approvare l'itinerario.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato.");
        }
    }

}
