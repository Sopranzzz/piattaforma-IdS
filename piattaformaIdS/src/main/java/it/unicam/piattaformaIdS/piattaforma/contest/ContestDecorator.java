package it.unicam.piattaformaIdS.piattaforma.contest;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@DiscriminatorValue("ContestDecorator")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_decorator", discriminatorType = DiscriminatorType.STRING)
public class ContestDecorator extends Contest {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contest_id", referencedColumnName = "ID")
    private final Contest contest;

    public ContestDecorator(Contest contest) {
        this.contest = contest;
    }

    @Override
    public String getInfoContest() {
        if(!(this.contest == null)) {
            return this.contest.getInfoContest();
        }
        return null;
    }

    @Override
    public int getDurata() {
        if(!(this.contest == null)) {
            return this.contest.getDurata();
        }
        return 0;
    }

}
