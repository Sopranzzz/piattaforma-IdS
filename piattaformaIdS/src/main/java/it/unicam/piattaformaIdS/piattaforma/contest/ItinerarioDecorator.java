package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.eccezioni.ItineraryAlreadyExistsException;
import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;

public class ItinerarioDecorator extends ContestDecorator {

    public ItinerarioDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiItinerario(Itinerario itinerario) {
        if (!contest.getItinerari().contains(itinerario)) {
            return super.aggiungiItinerario(itinerario);
        } else {
            throw new ItineraryAlreadyExistsException("L'Itinerario: " + itinerario.getNome() + " è già presente!");
        }
    }

}
