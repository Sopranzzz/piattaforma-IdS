package it.unicam.piattaformaIdS.piattaforma.contenuto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Contenuto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Contenuto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="contenuto_id")
    private long ID;

    private String nome;
    private String autore;
    private String descrizione;
    private StatoContenuto statoContenuto;

    public Contenuto(String nome, String autore, String descrizione) {
        this.nome = nome;
        this.autore = autore;
        this.descrizione = descrizione;
    }

}
