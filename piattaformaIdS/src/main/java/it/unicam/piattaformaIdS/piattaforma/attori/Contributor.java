package it.unicam.piattaformaIdS.piattaforma.attori;

import java.util.ArrayList;
import java.util.List;

public class Contributor extends Utente {

    private int dataInizioPubblicazioneContenuti;
    private List<String> contenuti;
    public boolean isAuthorized;

    public Contributor(String username, String email, String password) {
        super(username, email, password);
        this.contenuti = new ArrayList<String>();
        this.isAuthorized = false;
    }

    public void addGiorni(int giorniDaAggiungere) {
        this.dataInizioPubblicazioneContenuti += giorniDaAggiungere;
    }

    public void aggiungiContenuto(String contenuto) {
        this.contenuti.add(contenuto);
    }

    public void richiestaAutorizzazione(Gestore gestore) {
        if (this.dataInizioPubblicazioneContenuti >= 365) {
            gestore.getRichiesta(this);
        }
    }

    public List<String> getContenuti() {
        return this.contenuti;
    }
}
