package it.unicam.piattaformaIdS.richieste;

public class ApprovaPoiRequest {
    private Long poiId;
    private Long userId;

    public Long getPoiId() {
        return poiId;
    }

    public void setPoiId(Long poiId) {
        this.poiId = poiId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
