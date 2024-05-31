package it.unicam.piattaformaIdS.piattaforma.contenuto;

import it.unicam.piattaformaIdS.piattaforma.utenti.Turista;

public class Segnalazione {

    public Turista turista;
    public Contenuto contenuto;
    public String motivazione;

    public Segnalazione(Turista turista, Contenuto contenuto, String motivazione) {
        this.turista = turista;
        this.contenuto = contenuto;
        this.motivazione = motivazione;
    }
}
