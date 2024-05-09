package it.unicam.piattaformaIdS.piattaforma.contenuti;

import it.unicam.piattaformaIdS.piattaforma.attori.Utente;

public abstract class Contenuto {

    public Utente utente;
    public double idContenuto;
    public String nomeContenuto;
    public String descrizioneContenuto;

    public Contenuto(Utente utente, double idContenuto, String nomeContenuto, String descrizioneContenuto) {
        this.utente = utente;
        this.idContenuto = idContenuto;
        this.nomeContenuto = nomeContenuto;
        this.descrizioneContenuto = descrizioneContenuto;
    }

}
