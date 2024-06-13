package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.contenuto.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenutoRepository extends JpaRepository<Contenuto, Long> {
    List<Contenuto> findContenutiByUsernameAutore(String username);
}
