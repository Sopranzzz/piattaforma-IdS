package it.unicam.piattaformaIdS.richieste;

public class ApprovaItinerarioRequest {
    private Long itinerarioId;
    private Long userId;

    public Long getItinerarioId() {
        return this.itinerarioId;
    }

    public void setItinerarioId(Long ItinerarioId) {
        this.itinerarioId = ItinerarioId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
