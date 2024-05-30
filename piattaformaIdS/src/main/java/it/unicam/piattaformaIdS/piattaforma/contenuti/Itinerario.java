package it.unicam.piattaformaIdS.piattaforma.contenuti;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

import java.util.List;

public class Itinerario extends Contenuto {
    public int durata;
    public int lunghezza;
    public List<Long> listaPOI;

    public Itinerario(int durata, int lunghezza, Utente utente, double idContenuto, String nomeContenuto, String descrizioneContenuto) {
        super(utente, idContenuto, nomeContenuto, descrizioneContenuto);
        this.durata = durata;
        this.lunghezza = lunghezza;
    }

    public String getPercorrenza() {
        return "L'itinerario dura: " + this.durata + " ore.";
    }

    public String getLunghezza() {
        return "L'itinerario è lungo: " + this.lunghezza + " km.";
    }

}
