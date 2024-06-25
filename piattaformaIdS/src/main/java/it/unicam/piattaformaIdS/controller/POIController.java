package it.unicam.piattaformaIdS.controller;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.richieste.dto.DeletePoiDTO;
import it.unicam.piattaformaIdS.service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class POIController {

    @Autowired
    private POIService poiService;

    @PostMapping("/aggiungiPOI")
    public ResponseEntity<Object> aggiungiPOI(@RequestBody POI poi) {
        this.poiService.aggiungiPOI(poi);
        return new ResponseEntity<>("Il POI è stato aggiunto con stato: Accettato", HttpStatus.CREATED);
    }

    @PostMapping("/aggiungiPOIPending")
    public ResponseEntity<Object> aggiungiPOIPending(@RequestBody POI poi) {
        this.poiService.aggiungiPOIPending(poi);
        return new ResponseEntity<>("Il POI è stato aggiunto con stato: Pending", HttpStatus.CREATED);
    }

    @GetMapping("/getPOIDetails")
    public ResponseEntity<?> getPoiDetails(@RequestParam Long poiId) {
        POI poi = poiService.getPoiDetails(poiId);
        if (poi == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("POI con ID " + poiId + " non trovato");
        }
        return ResponseEntity.ok(poi);
    }

    @GetMapping("/getAllPOIs")
    public ResponseEntity<List<POI>> getAllPOIs() {
        List<POI> getPOIs = this.poiService.getAllPOIs();
        return new ResponseEntity<>(getPOIs, HttpStatus.OK);
    }

    @GetMapping("/getPendingPOIs")
    public ResponseEntity<List<POI>> getPendingPOIs() {
        List<POI> poiPending = this.poiService.getPOIPending();
        return new ResponseEntity<>(poiPending, HttpStatus.OK);
    }

    @DeleteMapping("/deletePOI")
    public ResponseEntity<?> deletePoi(@RequestBody DeletePoiDTO deletePoiDTO) {
        boolean success = poiService.deletePoi(deletePoiDTO.getPoiId());
        if (!success) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("POI con ID " + deletePoiDTO.getPoiId() + " non trovato");
        }
        return ResponseEntity.ok("POI con ID " + deletePoiDTO.getPoiId() + " è stato eliminato con successo");
    }

}
