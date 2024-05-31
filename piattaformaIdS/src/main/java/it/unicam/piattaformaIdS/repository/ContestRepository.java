package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.contest.ConcreteContest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestRepository extends JpaRepository<ConcreteContest, Long> {
    List<ConcreteContest> findByNome(String nome);
}
