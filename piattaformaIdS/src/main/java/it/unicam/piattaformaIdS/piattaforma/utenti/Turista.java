package it.unicam.piattaformaIdS.piattaforma.utenti;

public class Turista extends Utente {

    public String contenutoContest;
    public Turista(String username, String email, String password) {
        super(username, email, password);
    }

    public void inviaContenutoContest(String contenuto) {
        this.contenutoContest = contenuto;
    }
}
