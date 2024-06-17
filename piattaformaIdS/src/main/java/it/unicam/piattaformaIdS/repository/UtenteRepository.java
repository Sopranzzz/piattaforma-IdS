package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import it.unicam.piattaformaIdS.piattaforma.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    List<Utente> findByRuoloUtente(RuoloUtente ruoloUtente);
    Optional<Utente> findByUsername(String username);
    Optional<Utente> findByEmail(String email);
}


