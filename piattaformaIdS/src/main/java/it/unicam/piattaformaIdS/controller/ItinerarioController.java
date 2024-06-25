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
    public ResponseEntity<Object> aggiungiItinerario(@RequestBody Itinerario itinerario) {
        this.itinerarioService.aggiungiItinerario(itinerario);
        return new ResponseEntity<>("L'itinerario è stato aggiunto con stato: Accettato", HttpStatus.OK);
    }

    @PostMapping("/aggiungiItinerarioPending")
    public ResponseEntity<Object> aggiungiItinerarioPending(@RequestBody Itinerario itinerario) {
        this.itinerarioService.aggiungiItinerarioPending(itinerario);
        return new ResponseEntity<>("L'itinerario è stato aggiunto con stato: Pending", HttpStatus.CREATED);
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
