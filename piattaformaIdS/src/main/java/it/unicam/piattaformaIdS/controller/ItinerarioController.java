package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.service.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItinerarioController {

    @Autowired
    ItinerarioService itinerarioService;

    @PostMapping("/aggiungiItinerario")
    public ResponseEntity<Object> aggiungiItinerario(@RequestBody Itinerario itinerario) {
        this.itinerarioService.aggiungiItinerario(itinerario);
        return new ResponseEntity<>("L'itinerario è stato aggiunto", HttpStatus.OK);
    }

    @DeleteMapping("/eliminaItinerario")
    public ResponseEntity<Object> eliminaItinerario(@RequestBody Itinerario itinerario) {
        this.itinerarioService.eliminaItinerario(itinerario);
        return new ResponseEntity<>("L'itinerario è stato eliminato", HttpStatus.OK);
    }

}
