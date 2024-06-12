package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.piattaforma.contest.ConcreteContest;
import it.unicam.piattaformaIdS.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/contest")
public class ContestController {

    @Autowired
    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping("/creaContest")
    public ResponseEntity<Object> creaContest(@RequestBody ConcreteContest contest) {
        String nomeContest = contest.getNomeContest();
        String autore = contest.getAutore();
        String tema = contest.getTema();
        int durata = contest.getDurata();
        this.contestService.creaContest(nomeContest, autore, tema, durata);
        return ResponseEntity.status(HttpStatus.CREATED).body("Il Contest è stato creato con successo.");
    }

}
