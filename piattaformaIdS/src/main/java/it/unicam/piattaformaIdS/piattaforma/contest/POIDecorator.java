package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.eccezioni.POIAlreadyExistsException;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;

public class POIDecorator extends ContestDecorator {

    public POIDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiPOI(POI poi) {
        if (!contest.getPOIs().contains(poi)) {
            return super.aggiungiPOI(poi);
        } else {
            throw new POIAlreadyExistsException("Il POI: " + poi.getNome() + " è già presente!");
        }
    }

}
