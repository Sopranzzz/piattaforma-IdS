package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contenuto.StatoContenuto;
import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import it.unicam.piattaformaIdS.repository.ItinerarioRepository;
import it.unicam.piattaformaIdS.repository.POIRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContenutoService {

    private final POIRepository poiRepository;
    private final ItinerarioRepository itinerarioRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public ContenutoService(POIRepository poiRepository, ItinerarioRepository itinerarioRepository, UtenteRepository utenteRepository) {
        this.poiRepository = poiRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.utenteRepository = utenteRepository;
    }

    public void approvaPOI(Long poiId, Long userId) throws IllegalAccessException {
        Utente utente = this.utenteRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));
        if (utente.getRuoloUtente() != RuoloUtente.Curatore) {
            throw new IllegalAccessException("Non sei autorizzato ad approvare il POI");
        }
        this.poiRepository.findById(poiId).ifPresent(poi -> {
            poi.setStatoContenuto(StatoContenuto.Accettato);
            this.poiRepository.save(poi);
        });
    }

    public void approvaItinerario(Long itinerarioId, Long userId) throws IllegalAccessException {
        Utente utente = this.utenteRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));
        if (utente.getRuoloUtente() != RuoloUtente.Curatore) {
            throw new IllegalAccessException("Non sei autorizzato ad approvare il POI");
        }
        this.itinerarioRepository.findById(itinerarioId).ifPresent(itinerario -> {
            itinerario.setStatoContenuto(StatoContenuto.Accettato);
            this.itinerarioRepository.save(itinerario);
        });
    }

}
