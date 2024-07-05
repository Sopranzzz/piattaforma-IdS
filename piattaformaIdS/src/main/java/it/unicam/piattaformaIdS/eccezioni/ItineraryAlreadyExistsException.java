package it.unicam.piattaformaIdS.eccezioni;

public class ItineraryAlreadyExistsException extends RuntimeException {
    public ItineraryAlreadyExistsException(String message) {
        super(message);
    }
}
