package it.unicam.piattaformaIdS.piattaforma.utenti;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    // verificare l'aggiunta di listaNotifiche

    //@OneToMany
    //private List<Notifica> listaNotifiche;
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
/*public void aggiungiNotifica(Notifica notifica) {
        this.listaNotifiche.add(notifica);
    }

     */