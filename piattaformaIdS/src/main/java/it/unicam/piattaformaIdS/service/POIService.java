package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Contenuto;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POIService {

    public final ContenutoRepository contenutoRepository;

    @Autowired
    public POIService(ContenutoRepository contenutoRepository) {
        this.contenutoRepository = contenutoRepository;
    }

    public void aggiungiPOI(String nome, String autoreContenuto, String descrizioneContenuto) {
        POI poi = new POI(nome, autoreContenuto, descrizioneContenuto);
        this.contenutoRepository.save(poi);
    }

    public List<Contenuto> getAllPOI() {
        return this.contenutoRepository.findAll();
    }

    public void eliminaPOI(POI poi) {
        this.contenutoRepository.delete(poi);
    }

}
