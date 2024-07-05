package it.unicam.piattaformaIdS.piattaforma.contest;

import it.unicam.piattaformaIdS.eccezioni.UserAlreadyExistsException;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;

public class ContributorDecorator extends ContestDecorator {

    public ContributorDecorator(Contest contest) {
        super(contest);
    }

    @Override
    public boolean aggiungiPartecipante(Utente partecipante) {
        if (!contest.getUtenti().contains(partecipante)) {
            return super.aggiungiPartecipante(partecipante);
        } else {
            throw new UserAlreadyExistsException("Il partecipante: " + partecipante.getNome() + " è già iscritto!");
        }
    }

}
