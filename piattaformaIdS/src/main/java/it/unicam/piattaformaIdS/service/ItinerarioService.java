package it.unicam.piattaformaIdS.service;
import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.StatoContenuto;
import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import it.unicam.piattaformaIdS.repository.ItinerarioRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerarioService {

    public final ItinerarioRepository itinerarioRepository;
    public final UtenteRepository utenteRepository;

    public ItinerarioService(ItinerarioRepository itinerarioRepository, UtenteRepository utenteRepository) {
        this.itinerarioRepository = itinerarioRepository;
        this.utenteRepository = utenteRepository;
    }

    public void aggiungiItinerario(Itinerario itinerario, Long userId) {
        Utente utente = utenteRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));

        if (utente.getRuoloUtente() == RuoloUtente.Contributor_Autorizzato) {
            itinerario.setStatoContenuto(StatoContenuto.Accettato);
            itinerarioRepository.save(itinerario);
        } else {
            throw new SecurityException("Non sei autorizzato ad aggiungere un Itinerario!");
        }
    }

    public void aggiungiItinerarioPending(Itinerario itinerario, Long userId) {
        Utente utente = utenteRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));

        if (utente.getRuoloUtente() == RuoloUtente.Contributor) {
            itinerario.setStatoContenuto(StatoContenuto.Pending);
            itinerarioRepository.save(itinerario);
        } else {
            throw new SecurityException("Non sei autorizzato ad aggiungere un Itinerario in stato Pending!");
        }
    }

    public Itinerario getItinerarioDetails(Long itinerarioId) {
        return itinerarioRepository.findById(itinerarioId).orElse(null);
    }

    public List<Itinerario> getAllItinerari() {
        return this.itinerarioRepository.findAll();
    }

    public List<Itinerario> getItinerariPending() {
        return itinerarioRepository.findByStatoContenuto(StatoContenuto.Pending);
    }

    public boolean deleteItinerario(Long itinerarioId) {
        if (!itinerarioRepository.existsById(itinerarioId)) {
            return false;
        }
        itinerarioRepository.deleteById(itinerarioId);
        return true;
    }

}
