package it.unicam.piattaformaIdS.piattaforma.attori;

public class Curatore extends Utente {

    private String descrizione;
    public Curatore(String username, String email, String password) {
        super(username, email, password);
    }

    private void aggiungiContenutoContributor(Contributor contributor, String contenuto) {
        if (!contributor.isAuthorized) {
            contributor.aggiungiContenuto(contenuto);
        }
    }

    private void pubblicaSocial(String descrizione) {
        this.descrizione = descrizione;
    }
}
