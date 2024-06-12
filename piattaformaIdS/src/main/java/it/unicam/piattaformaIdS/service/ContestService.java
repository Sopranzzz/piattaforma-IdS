package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contest.ConcreteContest;
import it.unicam.piattaformaIdS.piattaforma.contest.Contest;
import it.unicam.piattaformaIdS.repository.ContestRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final UtenteRepository utenteRepository;
    private Contest contest;

    @Autowired
    public ContestService(ContestRepository contestRepository, UtenteRepository utenteRepository) {
        this.contestRepository = contestRepository;
        this.utenteRepository = utenteRepository;
    }

    public void creaContest(String nomeContest, String autore, String tema,
                            int durata) {
        ConcreteContest contest = new ConcreteContest(nomeContest, autore,
                tema, durata);
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

}
