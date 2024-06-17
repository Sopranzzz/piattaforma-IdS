package it.unicam.piattaformaIdS.service;

import it.unicam.piattaformaIdS.piattaforma.utenti.Comune;
import it.unicam.piattaformaIdS.repository.ComuneRepository;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {

    public final ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }

    public void aggiungiComune(Comune comune) {
        this.comuneRepository.save(comune);
    }

}
