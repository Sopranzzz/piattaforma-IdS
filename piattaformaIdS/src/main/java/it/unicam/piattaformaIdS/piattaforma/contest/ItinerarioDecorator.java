package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

public class ItinerarioDecorator extends ContestDecorator {

    public ItinerarioDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiItinerario(Itinerario itinerario) {
        return this.contest.aggiungiItinerario(itinerario);
    }
}
