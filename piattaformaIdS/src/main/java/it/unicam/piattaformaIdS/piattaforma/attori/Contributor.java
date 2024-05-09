package it.unicam.piattaformaIdS.piattaforma.attori;

public class Contributor extends Utente {

    private int dataInizioPubblicazione;

    public Contributor(String username, String email, String password) {
        super(username, email, password);
    }

    public void addGiorni(int dataInizioPubblicazione) {
        this.dataInizioPubblicazione++;
    }
}
