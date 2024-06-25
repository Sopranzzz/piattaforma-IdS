package it.unicam.piattaformaIdS.richieste.dto;

public class WinnerSelectionDTO {
    private Long contestId;
    private Long poiId;

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getPoiId() {
        return poiId;
    }

    public void setPoiId(Long poiId) {
        this.poiId = poiId;
    }
}
