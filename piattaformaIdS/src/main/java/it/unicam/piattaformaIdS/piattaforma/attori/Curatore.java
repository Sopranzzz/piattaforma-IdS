package it.unicam.piattaformaIdS.piattaforma.attori;

public class Curatore extends Utente {

    private String descrizione;
    public Curatore(String username, String email, String password) {
        super(username, email, password);
    }

    private void aggiungiContenutoContributor() {

    }

    private void pubblicaSocial(String descrizione) {
        this.descrizione = descrizione;
    }
}
