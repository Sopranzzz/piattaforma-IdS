package it.unicam.piattaformaIdS.piattaforma.attori;

import java.util.ArrayList;
import java.util.List;

public class Gestore extends Utente {

    private String nome;
    private String provincia;
    private String regione;
    private List<Turista> listaTuristi;
    private List<TuristaAutenticato> turistaAutenticatoList;
    private List<Contributor> contributorList;
    private List<ContributorAutorizzato> contributorAutorizzatoList;

    public Gestore(String username, String email, String password) {
        super(username, email, password);
    }

    public List<Turista> getTuristaList() {
        return this.listaTuristi;
    }

    public List<TuristaAutenticato> getTuristaAutenticatoList() {
        return this.turistaAutenticatoList;
    }

    public List<Contributor> getContributorList() {
        return this.contributorList;
    }

    public List<ContributorAutorizzato> getContributorAutorizzatoList() {
        return this.contributorAutorizzatoList;
    }

    public void addTuristaAutenticato(TuristaAutenticato turistaAutenticato) {
        this.turistaAutenticatoList.add(turistaAutenticato);
    }

    public void addContributorAutorizzato(ContributorAutorizzato contributorAutorizzato) {
        this.contributorAutorizzatoList.add(contributorAutorizzato);
    }

    public void addComune(String nome, String provincia, String regione) {
        this.nome = nome;
        this.provincia = provincia;
        this.regione = regione;
    }
}
