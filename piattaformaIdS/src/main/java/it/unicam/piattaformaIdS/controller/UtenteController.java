package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.piattaforma.utenti.Comune;
import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import it.unicam.piattaformaIdS.richieste.dto.DeleteUtenteDTO;
import it.unicam.piattaformaIdS.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/aggiungiUtente")
    public ResponseEntity<Object> aggiungiUtente(@RequestBody Utente utente) {
        String nome = utente.getNome();
        String username = utente.getUsername();
        String email = utente.getEmail();
        Comune comune = utente.getComune();
        RuoloUtente ruoloUtente = utente.getRuoloUtente();
        this.utenteService.aggiungiUtente(nome, username, email, comune, ruoloUtente);
        return new ResponseEntity<>("L'Utente è stato aggiunto", HttpStatus.CREATED);
    }

    @GetMapping("/getUtenti")
    public ResponseEntity<List<Utente>> getUtenti() {
        List<Utente> utenti = this.utenteService.getUtenti();
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @DeleteMapping("/rimuoviUtente")
    public ResponseEntity<?> deleteUtente(@RequestBody DeleteUtenteDTO deleteUtenteDTO) {
        boolean success = utenteService.deleteUtente(deleteUtenteDTO.getUtenteId());
        if (!success) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente con ID " + deleteUtenteDTO.getUtenteId() + " non trovato");
        }
        return ResponseEntity.ok("Utente con ID " + deleteUtenteDTO.getUtenteId() + " è stato eliminato con successo");
    }

}
