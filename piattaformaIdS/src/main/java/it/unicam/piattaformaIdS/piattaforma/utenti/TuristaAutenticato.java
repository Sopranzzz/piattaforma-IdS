package it.unicam.piattaformaIdS.piattaforma.utenti;

import lombok.Getter;
import lombok.Setter;

public class TuristaAutenticato extends Utente {

    @Setter
    @Getter
    public int punti;
    public int puntiAutenticazione;

    private int dataInizioAutenticazione = 0;
    private int dataFineAutenticazione = 0;
    public String contenutoContest;

    public TuristaAutenticato(String username, String email, String password) {
        super(username, email, password);
        this.punti = 0;
    }

    public void inviaContenutoContest(String contenutoContest) {
        this.contenutoContest = contenutoContest;
    }
}
