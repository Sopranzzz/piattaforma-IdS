package it.unicam.piattaformaIdS.controller;


import it.unicam.piattaformaIdS.service.RichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/richiesta")
public class RichiestaController {

    private final RichiestaService richiestaService;

    @Autowired
    public RichiestaController(RichiestaService richiestaService) {
        this.richiestaService = richiestaService;
    }

    @PutMapping("/richiediAutenticazione")
    public ResponseEntity<String> richiediAutenticazione(@RequestBody String email) {
        if (this.richiestaService.creaRichiestaAutenticazione(email)) {
            return ResponseEntity.ok("Autenticazione eseguita con successo.");
        }
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Non hai abbastanza punti per richiedere l'autenticazione.");
    }

    @PutMapping("/richiediAutorizzazione")
    public ResponseEntity<String> richiediAutorizzazione(@RequestBody String email) {
        if (this.richiestaService.creaRichiestaAutorizzazione(email)) {
            return ResponseEntity.ok("Autorizzazione eseguita con successo.");
        }
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Non hai abbastanza contributi per richiedere l'autorizzazione.");
    }

}