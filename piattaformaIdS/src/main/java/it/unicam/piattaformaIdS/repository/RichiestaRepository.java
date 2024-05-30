package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RichiestaRepository extends JpaRepository<Richiesta, Long> {
}
