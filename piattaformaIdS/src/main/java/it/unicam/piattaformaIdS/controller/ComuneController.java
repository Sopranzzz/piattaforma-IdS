package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.piattaforma.utenti.Comune;
import it.unicam.piattaformaIdS.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComuneController {

    @Autowired
    private ComuneService comuneService;

    @PostMapping("/aggiungiComune")
    public ResponseEntity<Object> aggiungiComune(@RequestBody Comune comune) {
        this.comuneService.aggiungiComune(comune);
        return new ResponseEntity<>("Il comune è stato aggiunto.", HttpStatus.OK);
    }

}
