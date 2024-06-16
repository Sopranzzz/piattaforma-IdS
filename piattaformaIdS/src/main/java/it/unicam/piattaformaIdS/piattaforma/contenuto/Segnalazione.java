package it.unicam.piattaformaIdS.piattaforma.contenuto;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="Segnalazione")
public class Segnalazione {

    @Id
    private long Id;
    @ManyToOne
    private Utente autore;
    @ManyToOne
    private Contenuto contenuto;
    public String motivazione;

    public Segnalazione(Utente autore, Contenuto contenuto, String motivazione) {
        this.autore = autore;
        this.contenuto = contenuto;
        this.motivazione = motivazione;
    }

}
