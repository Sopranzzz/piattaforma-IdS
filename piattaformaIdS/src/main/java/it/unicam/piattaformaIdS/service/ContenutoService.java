package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Contenuto;
import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContenutoService {

    public final ContenutoRepository contenutoRepository;

    @Autowired
    public ContenutoService(ContenutoRepository contenutoRepository) {
        this.contenutoRepository = contenutoRepository;
    }

    public void aggiungiItinerarioPending(Itinerario itinerario) {
        itinerario.setPending(true);
        this.contenutoRepository.save(itinerario);
    }

    public void aggiungiPOIPending(POI poi) {
        poi.setPending(true);
        this.contenutoRepository.save(poi);
    }

    public List<Contenuto> getContenutiInPending(String username) {
        return this.contenutoRepository.findContenutiByUsernameAutore(username)
                .stream().filter(Contenuto::isPending).toList();
    }

    public List<POI> getPOIsPending() {
        List<POI> result = new ArrayList<>();
        for (Contenuto c : this.contenutoRepository.findAll()) {
            if (c instanceof POI && c.isPending()) {
                result.add((POI) c);
            }
        }
        return result;
    }

    public List<Itinerario> getItinerariPending() {
        List<Itinerario> result = new ArrayList<>();
        for (Contenuto c : this.contenutoRepository.findAll()) {
            if (c instanceof Itinerario && c.isPending()) {
                result.add((Itinerario) c);
            }
        }
        return result;
    }


}
