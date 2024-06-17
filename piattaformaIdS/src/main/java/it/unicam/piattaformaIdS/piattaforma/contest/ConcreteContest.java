package it.unicam.piattaformaIdS.piattaforma.contest;
import it.unicam.piattaformaIdS.piattaforma.contenuto.Itinerario;
import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="contest")
public class ConcreteContest implements Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contest_id")
    private Long id;
    private String nome;
    private String autore;
    private String tema;
    private int durata;
    @ManyToMany
    @JoinTable(
            name = "contest_participants",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Utente> participants = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "contest_poi",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name = "poi_id")
    )
    private List<POI> poiList = new ArrayList<>();


    public ConcreteContest(String nome, String autore, String tema, int durata) {
        this.nome = nome;
        this.autore = autore;
        this.tema = tema;
        this.durata = durata;
    }

    public void addParticipant(Utente utente) {
        if (participants == null) {
            participants = new ArrayList<>();
        }
        participants.add(utente);
    }

    public void addPOI(POI poi) {
        if (poiList == null) {
            poiList = new ArrayList<>();
        }
        poiList.add(poi);
    }

    @Override
    public List<POI> getPOIs() {
        return poiList;
    }

    @Override
    public List<Itinerario> getItinerari() {
        return List.of();
    }

    @Override
    public boolean aggiungiPOI(POI poi) {
        return poiList.add(poi);
    }

    @Override
    public boolean aggiungiItinerario(Itinerario itinerario) {
        return false;
    }

    @Override
    public boolean aggiungiPartecipante(Utente partecipante) {
        return participants.add(partecipante);
    }

}
