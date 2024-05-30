package it.unicam.piattaformaIdS.piattaforma.utenti;

import java.util.List;

public class ContributorAutorizzato extends Utente {

    private boolean isAuthorized;
    private List<String> contenuti;
    public ContributorAutorizzato(String username, String email, String password) {
        super(username, email, password);
        this.isAuthorized = true;
    }

    public void aggiungiContenuto(String contenuto) {
        this.contenuti.add(contenuto);
    }
}
