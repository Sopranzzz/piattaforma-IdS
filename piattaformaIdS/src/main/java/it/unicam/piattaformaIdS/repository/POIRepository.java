package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.contenuto.POI;
import it.unicam.piattaformaIdS.piattaforma.contenuto.StatoContenuto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {
    List<POI> findByStatoContenuto(StatoContenuto stato);
}
