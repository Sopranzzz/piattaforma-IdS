package it.unicam.piattaformaIdS.service;
import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.StatoContenuto;
import it.unicam.piattaformaIdS.repository.ItinerarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerarioService {

    public final ItinerarioRepository itinerarioRepository;

    public ItinerarioService(ItinerarioRepository itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }

    public void aggiungiItinerario(Itinerario itinerario) {
        itinerario.setStatoContenuto(StatoContenuto.Accettato);
        this.itinerarioRepository.save(itinerario);
    }

    public void aggiungiItinerarioPending(Itinerario itinerario) {
        if(itinerario.getStatoContenuto().equals(StatoContenuto.Pending))
            this.itinerarioRepository.save(itinerario);
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
