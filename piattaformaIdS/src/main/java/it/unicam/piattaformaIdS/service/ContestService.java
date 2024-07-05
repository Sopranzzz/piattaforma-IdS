package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.contest.*;
import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import it.unicam.piattaformaIdS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final ItinerarioRepository itinerarioRepository;
    private final POIRepository poiRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository, ItinerarioRepository itinerarioRepository, POIRepository poiRepository, UtenteRepository utenteRepository) {
        this.contestRepository = contestRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.poiRepository = poiRepository;
        this.utenteRepository = utenteRepository;
    }

    public void creaContest(ConcreteContest contest, Long userId) {
        Utente utente = utenteRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato con ID: " + userId));

        if (utente.getRuoloUtente() != RuoloUtente.Animatore) {
            throw new SecurityException("Non sei autorizzato a creare un Contest!");
        }

        this.contestRepository.save(contest);
    }

    public void addParticipantAndPOIToContest(Long contestId, Long userId, Long poiId) {
        ConcreteContest contest = this.contestRepository.findById(contestId)
                .orElseThrow(() -> new IllegalArgumentException("Contest non trovato con ID: " + contestId));
        Utente user = this.utenteRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato con ID: " + userId));
        POI poi = this.poiRepository.findById(poiId)
                .orElseThrow(() -> new IllegalArgumentException("POI non trovato con ID: " + poiId));

        Contest decoratedContest = new ContributorDecorator(new POIDecorator(contest));
        boolean userAdded = decoratedContest.aggiungiPartecipante(user);
        boolean poiAdded = decoratedContest.aggiungiPOI(poi);

        if (!userAdded || !poiAdded) {
            throw new RuntimeException("Non è stato possibile aggiungere l'utente o il POI al contest.");
        }

        this.contestRepository.save(contest);
    }

    public void addParticipantAndItinerarioToContest(Long contestId, Long userId, Long itinerarioId) {
        ConcreteContest contest = this.contestRepository.findById(contestId)
                .orElseThrow(() -> new IllegalArgumentException("Contest non trovato con ID: " + contestId));

        Utente user = this.utenteRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato con ID: " + userId));

        Itinerario itinerario = this.itinerarioRepository.findById(itinerarioId)
                .orElseThrow(() -> new IllegalArgumentException("Itinerario non trovato con ID: " + itinerarioId));

        Contest decoratedContest = new ContributorDecorator(new ItinerarioDecorator(contest));
        boolean userAdded = decoratedContest.aggiungiPartecipante(user);
        boolean itineraryAdded = decoratedContest.aggiungiItinerario(itinerario);

        if (!userAdded || !itineraryAdded) {
            throw new RuntimeException("Non è stato possibile aggiungere l'utente o l'itinerario al contest.");
        }

        this.contestRepository.save(contest);
    }

    public void eliminaContest(ConcreteContest contest) {
        this.contestRepository.delete(contest);
    }

    public List<ConcreteContest> getContests() {
        return this.contestRepository.findAll();
    }

    public void save(ConcreteContest contest) {
        this.contestRepository.save(contest);
    }

    public ConcreteContest getContest(Long contestId) {
        Optional<ConcreteContest> contestOptional = contestRepository.findById(contestId);
        if (contestOptional.isEmpty()) {
            throw new IllegalArgumentException("Contest not found with ID: " + contestId);
        }
        return contestOptional.get();
    }

    public boolean setWinnerPoi(Long contestId, Long poiId) {
        Optional<ConcreteContest> contestOpt = contestRepository.findById(contestId);
        if (!contestOpt.isPresent()) {
            return false;
        }
        Optional<POI> poiOpt = poiRepository.findById(poiId);
        if (!poiOpt.isPresent()) {
            return false;
        }
        ConcreteContest contest = contestOpt.get();
        POI poi = poiOpt.get();

        contest.setWinnerPoi(poi);
        contestRepository.save(contest);
        return true;
    }

    public boolean setWinnerItinerario(Long contestId, Long itinerarioId) {
        Optional<ConcreteContest> contestOpt = contestRepository.findById(contestId);
        if (!contestOpt.isPresent()) {
            return false;
        }

        Optional<Itinerario> itinerarioOpt = itinerarioRepository.findById(itinerarioId);
        if (!itinerarioOpt.isPresent()) {
            return false;
        }

        ConcreteContest contest = contestOpt.get();
        Itinerario itinerario = itinerarioOpt.get();

        contest.setWinnerItinerario(itinerario);
        contestRepository.save(contest);
        return true;
    }

}
