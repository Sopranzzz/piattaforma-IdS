package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.service.ItinerarioService;
import it.unicam.piattaformaIdS.service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class POIController {

    @Autowired
    POIService poiService;

    @PostMapping("/aggiungiPOI")
    public ResponseEntity<Object> aggiungiPOI(@RequestBody POI poi) {
        String nome = poi.getNomeContenuto();
        String autoreContenuto = poi.getAutoreContenuto();
        String descrizioneContenuto = poi.getDescrizioneContenuto();
        this.poiService.aggiungiPOI(nome, autoreContenuto, descrizioneContenuto);
        return new ResponseEntity<>("L'itinerario è stato aggiunto", HttpStatus.OK);
    }

}
