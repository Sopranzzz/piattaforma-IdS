package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contest.ConcreteContest;
import it.unicam.piattaformaIdS.piattaforma.contest.Contest;
import it.unicam.piattaformaIdS.piattaforma.utenti.*;
import it.unicam.piattaformaIdS.repository.ContestRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final UtenteRepository utenteRepository;
    private Contest contest;
    private boolean isContestWithTuristi;
    private boolean isContestWithTuristiAutenticati;

    @Autowired
    public ContestService(ContestRepository contestRepository, UtenteRepository utenteRepository) {
        this.contestRepository = contestRepository;
        this.utenteRepository = utenteRepository;
    }

    public void creaContest(String nomeContest, String autore, List<Utente> partecipanti, String tema,
                            String regole, int dataInizio, int dataFine) {
        ConcreteContest contest = new ConcreteContest(nomeContest, autore, partecipanti,
                tema, regole, dataInizio, dataFine);
        this.contestRepository.save(contest);
    }

    public boolean creaContest2(ConcreteContest contest) {
        this.contest = contest;
        return true;
    }





    public void eliminaContest(Long contestId) {
        this.contestRepository.deleteById(contestId);
    }

    public List<ConcreteContest> getContest(String nome) {
        return contestRepository.findByNome(nome);
    }

    public Gestore getGestore() {
        return (Gestore) this.utenteRepository.findAllByUtente(getGestore().email);
    }

    public void chiudiContest(Animatore animatore, Long contestId) {
        ConcreteContest contest = contestRepository.findById(contestId);
        contest.setPartecipanti(null);
        contest.setTema(null);
        contest.setRegole(null);
        contest.setDataInizio(0);
        contest.setDataFine(0);
        contestRepository.save(contest);
    }

    public void getVincitore(Utente vincitore, Animatore animatore) {
        int puntiPremio = this.getGestore().puntiAutenticazione;
        if(vincitore instanceof Turista){
            TuristaAutenticato turistaAutenticato = new TuristaAutenticato(vincitore.getUsername(),
                    vincitore.getEmail(),vincitore.getPassword());
            turistaAutenticato.setPunti(((Turista) vincitore).punti + puntiPremio);
            this.utenteRepository.delete(vincitore);
            this.utenteRepository.save(turistaAutenticato);
        }
        if (vincitore instanceof TuristaAutenticato turistaAutenticato){
            turistaAutenticato.setPunti(turistaAutenticato.getPunti() + puntiPremio);
            this.utenteRepository.saveAndFlush(turistaAutenticato);
        }
        this.chiudiContest(animatore);
    }

}
