package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

public class ContestDecorator implements Contest {
    protected Contest contest;

    public ContestDecorator(Contest contest) {
        this.contest = contest;
    }

    @Override
    public List<POI> getPOIs() {
        return contest.getPOIs();
    }

    @Override
    public List<Itinerario> getItinerari() {
        return contest.getItinerari();
    }

    @Override
    public boolean aggiungiPOI(POI poi) {
        return contest.aggiungiPOI(poi);
    }

    @Override
    public boolean aggiungiItinerario(Itinerario itinerario) {
        return contest.aggiungiItinerario(itinerario);
    }

    @Override
    public boolean aggiungiPartecipante(Utente partecipante) {
        return contest.aggiungiPartecipante(partecipante);
    }
}

