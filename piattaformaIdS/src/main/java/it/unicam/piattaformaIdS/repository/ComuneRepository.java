package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.utenti.Comune;
import it.unicam.piattaformaIdS.piattaforma.utenti.RuoloUtente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComuneRepository extends JpaRepository<Comune, Long> {
    List<Comune> findByNome(String nome);
    Optional<Comune> findById(Long id);
}
