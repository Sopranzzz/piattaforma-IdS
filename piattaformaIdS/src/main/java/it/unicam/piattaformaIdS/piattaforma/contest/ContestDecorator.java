package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

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

/*public abstract class ContestDecorator implements Contest {
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
        if (poi == null) {
            throw new IllegalArgumentException("POI non può essere nullo");
        }
        return contest.aggiungiPOI(poi);
    }

    @Override
    public boolean aggiungiItinerario(Itinerario itinerario) {
        if (itinerario == null) {
            throw new IllegalArgumentException("Itinerario non può essere nullo");
        }
        return contest.aggiungiItinerario(itinerario);
    }

    @Override
    public boolean aggiungiPartecipante(Utente partecipante) {
        if (partecipante == null) {
            throw new IllegalArgumentException("Partecipante non può essere nullo");
        }
        return contest.aggiungiPartecipante(partecipante);
    }
}


 */

