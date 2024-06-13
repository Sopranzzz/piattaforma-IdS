package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, String> {
    List<Utente> findAllByUsername(String username);

}
