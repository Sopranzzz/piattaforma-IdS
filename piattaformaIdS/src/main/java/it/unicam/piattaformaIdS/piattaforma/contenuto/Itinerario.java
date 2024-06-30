package it.unicam.piattaformaIdS.piattaforma.contenuto;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Builder
@Data
@Entity
public class Itinerario extends Contenuto {
    public int durata;
    @ManyToMany
    public List<POI> tappe;

    public Itinerario(int durata, List<POI> tappe) {
        this.durata = durata;
        this.tappe = tappe;
    }

}
