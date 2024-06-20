package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.utenti.Comune;
import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    public final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void aggiungiUtente(String nome, String username, String email, Comune comune, RuoloUtente ruoloUtente) {
        if (this.utenteRepository.findByUsername(username).isPresent()) {
            throw new IllegalStateException("Username già in uso");
        }
        if (this.utenteRepository.findByEmail(email).isPresent()) {
            throw new IllegalStateException("Email già in uso");
        }
        Utente utente = new Utente(nome, username, email, comune, ruoloUtente);
        this.utenteRepository.save(utente);
    }

    public List<Utente> getUtenti() {
        return this.utenteRepository.findAll();
    }

    public boolean deleteUtente(Long utenteId) {
        if (!utenteRepository.existsById(utenteId)) {
            return false;
        }
        utenteRepository.deleteById(utenteId);
        return true;
    }

}
