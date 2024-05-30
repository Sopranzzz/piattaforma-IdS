package it.unicam.piattaformaIdS.piattaforma;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import lombok.Getter;

@Getter
public class Richiesta {

    private Utente utente;
    private long data;
    private String statoRichiesta;

    public Richiesta(Utente utente, long data, String statoRichiesta) {
        this.utente = utente;
        this.data = data;
        this.statoRichiesta = statoRichiesta;
    }

}
