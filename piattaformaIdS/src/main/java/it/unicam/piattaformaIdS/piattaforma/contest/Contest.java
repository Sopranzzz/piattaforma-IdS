package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

import java.util.List;

public interface Contest {

    List<POI> getPOIs();
    List<Itinerario> getItinerari();
    boolean aggiungiPOI(POI poi);
    boolean aggiungiItinerario(Itinerario itinerario);
    boolean aggiungiPartecipante(Utente partecipante);

}
