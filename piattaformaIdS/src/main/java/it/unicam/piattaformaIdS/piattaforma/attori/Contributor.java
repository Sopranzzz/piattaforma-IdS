package it.unicam.piattaformaIdS.piattaforma.attori;

public class Contributor extends Utente {

    private int giorni;

    public Contributor(String username, String email, String password) {
        super(username, email, password);
    }

    public void addGiorni(int giorni) {
        this.giorni++;
    }
}
