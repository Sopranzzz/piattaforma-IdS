package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

public class ContributorDecorator extends ContestDecorator {

    public ContributorDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiPartecipante(Utente partecipante) {
        return contest.aggiungiPartecipante(partecipante);
    }
}
