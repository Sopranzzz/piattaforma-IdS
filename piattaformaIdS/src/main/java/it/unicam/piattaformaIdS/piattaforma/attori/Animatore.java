package it.unicam.piattaformaIdS.piattaforma.attori;

public class Animatore extends Utente {

    private String temaContest;
    private int durataContest;

    public Animatore(String username, String email, String password) {
        super(username, email, password);
    }

    public void creaContest(String tema, int durata) {
        this.temaContest = tema;
        this.durataContest = durata;
    }

    public String terminaContest() {
        // TODO: aggiungere logica
        return "Contest has finished.";
    }

    public void valutaContest() {
        // TODO: aggiungere logica
    }

    public Animatore getAccount() {
        return this;
    }
}
