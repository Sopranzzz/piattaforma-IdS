package it.unicam.piattaformaIdS.piattaforma.utenti;

public class TuristaAutenticato extends Utente {

    private int dataInizioAutenticazione = 0;
    private int dataFineAutenticazione = 0;
    public String contenutoContest;

    public TuristaAutenticato(String username, String email, String password) {
        super(username, email, password);
    }

    public void inviaContenutoContest(String contenutoContest) {
        this.contenutoContest = contenutoContest;
    }
}
