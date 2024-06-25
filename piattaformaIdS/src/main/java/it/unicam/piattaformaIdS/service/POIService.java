package it.unicam.piattaformaIdS.service;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.contenuto.StatoContenuto;
import it.unicam.piattaformaIdS.repository.POIRepository;
import it.unicam.piattaformaIdS.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POIService {

    public final POIRepository poiRepository;
    public final UtenteRepository utenteRepository;

    @Autowired
    public POIService(POIRepository poiRepository, UtenteRepository utenteRepository) {
        this.poiRepository = poiRepository;
        this.utenteRepository = utenteRepository;
    }

    public void aggiungiPOI(POI poi) {
        poi.setStatoContenuto(StatoContenuto.Accettato);
        this.poiRepository.save(poi);
    }

    public void aggiungiPOIPending(POI poi) {
        poi.setStatoContenuto(StatoContenuto.Pending);
        this.poiRepository.save(poi);
    }

    public POI getPoiDetails(Long poiId) {
        return poiRepository.findById(poiId).orElse(null);
    }

    public List<POI> getAllPOIs() {
        return this.poiRepository.findAll();
    }

    public List<POI> getPOIPending() {
        return this.poiRepository.findByStatoContenuto(StatoContenuto.Pending);
    }

    public boolean deletePoi(Long poiId) {
        if (!poiRepository.existsById(poiId)) {
            return false;
        }
        poiRepository.deleteById(poiId);
        return true;
    }

}
