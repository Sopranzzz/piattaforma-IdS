package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;

public class POIDecorator extends ContestDecorator {

    public POIDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiPOI(POI poi) {
        return this.contest.aggiungiPOI(poi);
    }

}
