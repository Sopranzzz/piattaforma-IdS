package it.unicam.piattaformaIdS.piattaforma.contenuto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class Posizione {
    private float latitudine;
    private float longitudine;
}
