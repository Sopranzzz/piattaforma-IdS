package it.unicam.piattaformaIdS.piattaforma;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

public class Richiesta {

    private Utente utente;
    private int data;
    private String statoRichiesta;

    public Richiesta(Utente utente, int data, String statoRichiesta) {
        this.utente = utente;
        this.data = data;
        this.statoRichiesta = statoRichiesta;
    }

    public Utente getUtente() {
        return utente;
    }

    public int getData() {
        return data;
    }

    public String getStatoRichiesta() {
        return statoRichiesta;
    }
}
