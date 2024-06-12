package it.unicam.piattaformaIdS.piattaforma.contest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_contest", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor(force = true)
@Getter
public abstract class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    abstract public String getInfoContest();
    abstract public int getDurata();
}
