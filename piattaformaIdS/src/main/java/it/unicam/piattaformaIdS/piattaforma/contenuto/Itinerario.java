package it.unicam.piattaformaIdS.piattaforma.contenuto;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@DiscriminatorValue("Itinerario")
public class Itinerario extends Contenuto {
    public int durata;
    @Getter
    @ElementCollection
    public List<Long> tappe;

    public Itinerario(String nomeContenuto,String autoreContenuto, String descrizioneContenuto, List<Long> tappe, int durata) {
        super(nomeContenuto, autoreContenuto, descrizioneContenuto);
        this.tappe = tappe;
        this.durata = durata;
    }

    public String getPercorrenza() {
        return "L'itinerario dura: " + this.durata + " ore.";
    }

}
