package it.unicam.piattaformaIdS.piattaforma.contenuto;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;


@NoArgsConstructor
@Builder
@Data
@Entity
public class POI extends Contenuto {

    @Embedded
    private Posizione posizione;

    public POI(Posizione posizione) {
        this.posizione = posizione;
    }
}
