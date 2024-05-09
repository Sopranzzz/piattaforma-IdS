package it.unicam.piattaformaIdS.piattaforma.attori;

public class Animatore extends Utente {

    private String tema;
    private int durata;

    public Animatore(String username, String email, String password) {
        super(username, email, password);
    }

    public void creaContest(String tema, int durata) {
        this.tema = tema;
        this.durata = durata;
    }

    public Animatore getAccount() {
        return this;
    }
}
