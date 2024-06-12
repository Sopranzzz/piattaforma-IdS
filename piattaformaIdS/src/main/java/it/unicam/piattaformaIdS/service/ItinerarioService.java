package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.repository.ContenutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ItinerarioService {

    public final ContenutoRepository contenutoRepository;

    public ItinerarioService(ContenutoRepository contenutoRepository) {
        this.contenutoRepository = contenutoRepository;
    }

    public boolean aggiungiItinerario(Itinerario itinerario) {
        this.contenutoRepository.save(itinerario);
        return true;
    }

    public boolean eliminaItinerario(long id) {
        if(this.contenutoRepository.existsById(id)) {
            Itinerario daEliminare = (Itinerario) this.contenutoRepository.findById(id).get();
            this.contenutoRepository.deleteById(id);
        }
        return true;
    }

}
