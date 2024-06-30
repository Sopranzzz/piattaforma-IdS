package it.unicam.piattaformaIdS.piattaforma.utenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="Notifica")
public class Notifica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="notifica_id")
    private Long Id;
    private String titolo;
    private String descrizione;

    public Notifica(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

}
