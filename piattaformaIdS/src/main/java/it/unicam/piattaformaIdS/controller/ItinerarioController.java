package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.richieste.dto.DeleteItinerarioDTO;
import it.unicam.piattaformaIdS.service.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @PostMapping("/aggiungiItinerario")
    public ResponseEntity<String> aggiungiItinerario(@RequestBody Itinerario itinerario, @RequestParam Long userId) {
        try {
            itinerarioService.aggiungiItinerario(itinerario, userId);
            return ResponseEntity.ok("L'itinerario è stato aggiunto con successo!");
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore: " + e.getMessage());
        }
    }

    @PostMapping("/aggiungiItinerarioPending")
    public ResponseEntity<String> aggiungiItinerarioPending(@RequestBody Itinerario itinerario, @RequestParam Long userId) {
        try {
            itinerarioService.aggiungiItinerarioPending(itinerario, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("L'itinerario è stato aggiunto con stato: Pending.");
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore: " + e.getMessage());
        }
    }

    @GetMapping("/getItinerarioDetails")
    public ResponseEntity<?> getItinerarioDetails(@RequestParam Long itinerarioId) {
        Itinerario itinerario = itinerarioService.getItinerarioDetails(itinerarioId);
        if (itinerario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itinerario con ID " + itinerarioId + " non trovato");
        }
        return ResponseEntity.ok(itinerario);
    }

    @GetMapping("/getAllItinerari")
    public ResponseEntity<List<Itinerario>> getAllItinerari() {
        List<Itinerario> itinerari = this.itinerarioService.getAllItinerari();
        return new ResponseEntity<>(itinerari, HttpStatus.OK);
    }

    @GetMapping("/getItinerariPending")
    public ResponseEntity<List<Itinerario>> getItinerariPending() {
        List<Itinerario> itinerariPending = this.itinerarioService.getItinerariPending();
        return new ResponseEntity<>(itinerariPending, HttpStatus.OK);
    }

    @DeleteMapping("/deleteItinerario")
    public ResponseEntity<?> deleteItinerario(@RequestBody DeleteItinerarioDTO deleteItinerarioDTO) {
        boolean success = itinerarioService.deleteItinerario(deleteItinerarioDTO.getItinerarioId());
        if (!success) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itinerario con ID " + deleteItinerarioDTO.getItinerarioId() + " non trovato");
        }
        return ResponseEntity.ok("Itinerario con ID " + deleteItinerarioDTO.getItinerarioId() + " è stato eliminato con successo");
    }

}
