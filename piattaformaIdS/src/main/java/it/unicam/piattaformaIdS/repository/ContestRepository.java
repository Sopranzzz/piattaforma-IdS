package it.unicam.piattaformaIdS.repository;

import it.unicam.piattaformaIdS.piattaforma.contest.ConcreteContest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ContestRepository extends JpaRepository<ConcreteContest, Long> {
    List<ConcreteContest> findByNome(String nome);

    // Trova contest per nome con tutti i dettagli e le relazioni caricate
    @Query("SELECT cc FROM ConcreteContest cc LEFT JOIN FETCH cc.participants WHERE cc.nome = :nome")
    List<ConcreteContest> findByNameWithParticipants(String nome);

    // Trova tutti gli id degli utenti partecipanti ad un contest specifico che non hanno vinto
    @Query("SELECT u.id FROM ConcreteContest cc JOIN cc.participants u WHERE cc.id = :contestId AND u.id <> :winnerId")
    Set<Long> findLoserParticipantIdsByContestIdAndWinnerId(Long contestId, Long winnerId);

}
