package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.Richiesta;
import it.unicam.piattaformaIdS.piattaforma.utenti.*;
import it.unicam.piattaformaIdS.repository.RichiestaRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RichiestaService {

    private final UtenteRepository utenteRepository;
    private final RichiestaRepository richiestaRepository;

    public RichiestaService(UtenteRepository utenteRepository, RichiestaRepository richiestaRepository) {
        this.utenteRepository = utenteRepository;
        this.richiestaRepository = richiestaRepository;
    }

    public Gestore getGestore() {
        return (Gestore) this.utenteRepository.findAllByUtente(getGestore().email);
    }

    public boolean creaRichiestaAutenticazione(String email) {
        if (!this.utenteRepository.existsById(email)) {
            return false;
        }
        Turista turista = (Turista) this.utenteRepository.findById(email).get();
        int puntiAutenticazione = this.getGestore().puntiAutenticazione;
        if (turista.punti >= puntiAutenticazione) {
            TuristaAutenticato turistaAutenticato = new TuristaAutenticato(turista.username, turista.email, turista.password);
            turistaAutenticato.setPunti(turista.punti - turistaAutenticato.puntiAutenticazione);
            this.utenteRepository.delete(turista);
            this.utenteRepository.save(turistaAutenticato);

            Richiesta richiesta = new Richiesta(turista, System.currentTimeMillis(), "Approvata");
            richiestaRepository.save(richiesta);

            return true;
        }
        return false;
    }

    public boolean creaRichiestaAutorizzazione(String email) {
        if (!this.utenteRepository.existsById(email)) {
            return false;
        }
        Contributor contributor = (Contributor) this.utenteRepository.findById(email).get();
        List<String> contenutiPubblicati = contributor.getContenuti();
        if (contenutiPubblicati.size() > 20) {
            ContributorAutorizzato contributorAutorizzato = new ContributorAutorizzato
                    (contributor.username, contributor.email, contributor.password);
            this.utenteRepository.delete(contributor);
            this.utenteRepository.save(contributorAutorizzato);

            Richiesta richiesta = new Richiesta(contributor, System.currentTimeMillis(), "Approvata");
            richiestaRepository.save(richiesta);

            return true;
        }
        return false;
    }

}
