package it.unicam.piattaformaIdS.piattaforma.utenti;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor(force = true)
@DiscriminatorValue("Gestore")
public class Gestore extends Utente {

    public int puntiAutenticazione;
    public int contenutiPubblicati;

    public Gestore(String username, String email, String password, int puntiAutenticazione, int contenutiPubblicati) {
        super(username, email, password);
        this.contenutiPubblicati = contenutiPubblicati;
        this.puntiAutenticazione = puntiAutenticazione;
    }

}
