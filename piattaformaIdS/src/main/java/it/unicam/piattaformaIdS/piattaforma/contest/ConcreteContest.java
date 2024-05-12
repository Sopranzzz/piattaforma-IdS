package it.unicam.piattaformaIdS.piattaforma.contest;
import it.unicam.piattaformaIdS.piattaforma.attori.Utente;
import java.util.List;

public class ConcreteContest extends Contest {
    private String autore;
    public List<Utente> partecipanti;
    public String nome;
    public String tema;
    public String regole;
    public int dataInizio;
    public int dataFine;

    public ConcreteContest(String autore, String nome, String tema, String regole, int dataInizio, int dataFine) {
        this.autore = autore;
        this.nome = nome;
        this.tema = tema;
        this.regole = regole;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    @Override
    public String getInfoContest() {
        return "I dettagli del contest sono i seguenti: Autore: " + this.autore + ";" +
                "Nome: " + this.nome + ";" + "Tema: " + this.tema;
    }

    @Override
    public String getDurata() {
        return "Il contest è iniziato il giorno:" + this.dataInizio + "e termina il giorno:" + this.dataFine;
    }
}
