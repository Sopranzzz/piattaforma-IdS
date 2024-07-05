package it.unicam.piattaformaIdS.controller;

import it.unicam.piattaformaIdS.eccezioni.ItineraryAlreadyExistsException;
import it.unicam.piattaformaIdS.eccezioni.POIAlreadyExistsException;
import it.unicam.piattaformaIdS.eccezioni.UserAlreadyExistsException;
import it.unicam.piattaformaIdS.piattaforma.contest.ConcreteContest;
import it.unicam.piattaformaIdS.richieste.dto.ItinerarioWinnderSelectionDTO;
import it.unicam.piattaformaIdS.service.ContestService;
import it.unicam.piattaformaIdS.richieste.ParticipantAndItinerarioRequest;
import it.unicam.piattaformaIdS.richieste.ParticipantAndPOIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContestController {

    @Autowired
    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping("/creaContest")
    public ResponseEntity<Object> creaContest(@RequestBody ConcreteContest contest) {
        try {
            contestService.creaContest(contest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Il Contest è stato creato con successo.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore nella creazione del contest: " + e.getMessage());
        }
    }

    @PostMapping("/iscrivitiConPOI")
    public ResponseEntity<String> addParticipantAndPOI(@RequestBody ParticipantAndPOIRequest request) {
        try {
            contestService.addParticipantAndPOIToContest(request.getContestId(), request.getUserId(), request.getPoiId());
            return ResponseEntity.ok("Utente e POI aggiunti con successo al contest.");
        } catch (UserAlreadyExistsException | POIAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore: " + e.getMessage());
        }
    }

    @PostMapping("/iscrivitiConItinerario")
    public ResponseEntity<String> addParticipantAndItinerario(@RequestBody ParticipantAndItinerarioRequest request) {
        try {
            contestService.addParticipantAndItinerarioToContest(request.getContestId(), request.getUserId(), request.getItinerarioId());
            return ResponseEntity.ok("Utente e itinerario aggiunti con successo al contest.");
        } catch (UserAlreadyExistsException | ItineraryAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore: " + e.getMessage());
        }
    }

    @PutMapping("/scegliPOIVincitore")
    public ResponseEntity<?> setWinnerPoi(@RequestBody ItinerarioWinnderSelectionDTO winnerSelection) {
        boolean success = contestService.setWinnerPoi(winnerSelection.getContestId(), winnerSelection.getPoiId());
        if (!success) {
            return ResponseEntity.badRequest().body("Contest o POI non trovato");
        }
        return ResponseEntity.ok("Il POI con ID: " + winnerSelection.getPoiId() + " è il vincitore del contest con ID: " + winnerSelection.getContestId());
    }

    @PutMapping("/scegliItinerarioVincitore")
    public ResponseEntity<?> setWinnerItinerario(@RequestBody ItinerarioWinnderSelectionDTO winnerSelection) {
        boolean success = contestService.setWinnerItinerario(winnerSelection.getContestId(), winnerSelection.getItinerarioId());
        if (!success) {
            return ResponseEntity.badRequest().body("Contest o Itinerario non trovato");
        }
        return ResponseEntity.ok("L'Itinerario con ID: " + winnerSelection.getItinerarioId() + " è il vincitore del contest con ID: " + winnerSelection.getContestId());
    }

}

