package it.unicam.piattaformaIdS.piattaforma.contest;

public class ContestDecorator extends Contest {

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
    public String getDurata() {
        if(!(this.contest == null)) {
            return this.contest.getDurata();
        }
        return null;
    }
}
