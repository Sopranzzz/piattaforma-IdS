package it.unicam.piattaformaIdS.piattaforma.contest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ConcreteContest")
@NoArgsConstructor(force = true)
@Getter
public class ConcreteContest extends Contest {

    private String nome;
    private String autore;
    private String tema;
    private int durata;

    public ConcreteContest(String nomeContest, String autore,
                           String tema, int durata) {
        this.nome = nomeContest;
        this.autore = autore;
        this.tema = tema;
        this.durata = durata;
    }

    @Override
    public String getInfoContest() {
        return "I dettagli del contest sono i seguenti: Autore: " + this.autore + ";" +
                "Nome: " + this.nome + ";" + "Tema: " + this.tema;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

}
