package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.utenti.Notifica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificaRepository extends JpaRepository<Notifica, Long> {
}
