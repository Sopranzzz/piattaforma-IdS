package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.Richiesta;
import it.unicam.piattaformaIdS.piattaforma.contenuto.Contenuto;
import it.unicam.piattaformaIdS.piattaforma.utenti.*;
import it.unicam.piattaformaIdS.repository.ContenutoRepository;
import it.unicam.piattaformaIdS.repository.RichiestaRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RichiestaService {

    private final UtenteRepository utenteRepository;
    private final RichiestaRepository richiestaRepository;
    private final ContenutoRepository contenutoRepository;

    public RichiestaService(UtenteRepository utenteRepository, RichiestaRepository richiestaRepository, ContenutoRepository contenutoRepository) {
        this.utenteRepository = utenteRepository;
        this.richiestaRepository = richiestaRepository;
        this.contenutoRepository = contenutoRepository;
    }

    public Gestore getGestore() {
        return (Gestore) this.utenteRepository.findAllByUsername(getGestore().username);
    }

    public boolean creaRichiestaAutenticazione(String email) {
        if (!this.utenteRepository.existsById(email)) {
            return false;
        }
        Turista turista = (Turista) this.utenteRepository.findById(email).get();
        int puntiAutenticazione = this.getGestore().puntiAutenticazione;
        if (turista.punti >= puntiAutenticazione) {
            TuristaAutenticato turistaAutenticato = new TuristaAutenticato(turista.username, turista.email, turista.password);
            turistaAutenticato.setPunti(turista.punti - turistaAutenticato.punti);
            this.utenteRepository.delete(turista);
            this.utenteRepository.save(turistaAutenticato);
            Richiesta richiesta = new Richiesta(System.currentTimeMillis(), "Approvata");
            richiestaRepository.save(richiesta);

            return true;
        }
        return false;
    }

    public boolean creaRichiestaAutorizzazione(String username) {
        if (!this.utenteRepository.existsById(username)) {
            return false;
        }
        Contributor contributor = (Contributor) this.utenteRepository.findById(username).get();
        List<Contenuto> contenutiPubblicati = this.contenutoRepository.findByAutoreContenuto(username);
        if (contenutiPubblicati.size() > 20) {
            ContributorAutorizzato contributorAutorizzato = new ContributorAutorizzato
                    (contributor.username, contributor.email, contributor.password);
            this.utenteRepository.delete(contributor);
            this.utenteRepository.save(contributorAutorizzato);
            Richiesta richiesta = new Richiesta(System.currentTimeMillis(), "Approvata");
            richiestaRepository.save(richiesta);
            return true;
        }
        return false;
    }

}
