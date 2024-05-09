package it.unicam.piattaformaIdS.piattaforma.contenuti;

import it.unicam.piattaformaIdS.piattaforma.attori.Utente;

public class Itinerario extends Contenuto {
    public int percorrenza;
    public int lunghezza;

    public Itinerario(int percorrenza, int lunghezza, Utente utente, double idContenuto, String nomeContenuto, String descrizioneContenuto) {
        super(utente, idContenuto, nomeContenuto, descrizioneContenuto);
        this.percorrenza = percorrenza;
        this.lunghezza = lunghezza;
    }

    public String getPercorrenza() {
        return "L'itinerario dura: " + this.percorrenza + " ore.";
    }

    public String getLunghezza() {
        return "L'itinerario è lungo: " + this.lunghezza + " km.";
    }

}
