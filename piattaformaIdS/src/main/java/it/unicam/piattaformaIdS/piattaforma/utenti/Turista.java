package it.unicam.piattaformaIdS.piattaforma.utenti;

public class Turista extends Utente {

    public String contenutoContest;
    public int punti;

    public Turista(String username, String email, String password, int punti) {
        super(username, email, password);
        this.punti = punti;
    }

}
