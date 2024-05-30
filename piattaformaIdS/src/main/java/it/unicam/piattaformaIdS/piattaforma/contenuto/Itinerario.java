package it.unicam.piattaformaIdS.piattaforma.contenuto;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

import java.util.List;

public class Itinerario extends Contenuto {
    public int durata;
    public List<POI> tappe;

    public Itinerario(int durata, List<POI> tappe, Utente utente, double idContenuto, String nomeContenuto, String descrizioneContenuto) {
        super(utente, idContenuto, nomeContenuto, descrizioneContenuto);
        this.durata = durata;
        this.tappe = tappe;
    }

    public String getPercorrenza() {
        return "L'itinerario dura: " + this.durata + " ore.";
    }

}
