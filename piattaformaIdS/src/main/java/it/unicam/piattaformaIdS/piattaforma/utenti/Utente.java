package it.unicam.piattaformaIdS.piattaforma.utenti;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="Utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_id")
    private Long id;
    private String nome;
    private String username;
    private String email;
    @ManyToOne
    @JoinColumn(name = "comune_id")
    private Comune comune;
    @Enumerated(EnumType.STRING)
    private RuoloUtente ruoloUtente;

    public Utente(String nome, String username, String email, Comune comune, RuoloUtente ruoloUtente) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.comune = comune;
        this.ruoloUtente = ruoloUtente;
    }

    @JsonProperty
    public String getComuneNome() {
        return this.comune.getNome();
    }

}