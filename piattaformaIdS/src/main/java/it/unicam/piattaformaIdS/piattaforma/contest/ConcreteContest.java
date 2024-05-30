package it.unicam.piattaformaIdS.piattaforma.contest;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ConcreteContest")
@NoArgsConstructor(force = true)
@Getter
public class ConcreteContest extends Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String nomeContest;
    private String autore;
    @ManyToMany
    private List<Utente> partecipanti;
    private String tema;
    private String regole;
    private int dataInizio;
    private int dataFine;

    public ConcreteContest(String nomeContest, String autore, List<Utente> partecipanti,
                           String tema, String regole, int dataInizio, int dataFine) {
        this.nomeContest = nomeContest;
        this.autore = autore;
        this.partecipanti = partecipanti;
        this.tema = tema;
        this.regole = regole;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    @Override
    public String getInfoContest() {
        return "I dettagli del contest sono i seguenti: Autore: " + this.autore + ";" +
                "Nome: " + this.nomeContest + ";" + "Tema: " + this.tema;
    }

    @Override
    public String getDurata() {
        return "Il contest è iniziato il giorno:" + this.dataInizio + "e termina il giorno:" + this.dataFine;
    }
}
