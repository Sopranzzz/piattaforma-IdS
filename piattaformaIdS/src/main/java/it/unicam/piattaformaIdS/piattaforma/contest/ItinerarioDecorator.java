package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;

public class ItinerarioDecorator extends ContestDecorator {

    public ItinerarioDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiItinerario(Itinerario itinerario) {
        return contest.aggiungiItinerario(itinerario);
    }
}
