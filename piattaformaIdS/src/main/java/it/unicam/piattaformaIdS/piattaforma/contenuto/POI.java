package it.unicam.piattaformaIdS.piattaforma.contenuto;

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
