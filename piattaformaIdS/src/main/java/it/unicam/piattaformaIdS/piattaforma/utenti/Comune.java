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
@Table(name="Comune")
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comune_id")
    private long Id;
    private String nome;
    private String provincia;
    private String regione;

    public Comune(String nome, String provincia, String regione) {
        this.nome = nome;
        this.provincia = provincia;
        this.regione = regione;
    }
}
