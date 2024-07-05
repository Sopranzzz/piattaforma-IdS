package it.unicam.piattaformaIdS.eccezioni;

public class POIAlreadyExistsException extends RuntimeException {
    public POIAlreadyExistsException(String message) {
        super(message);
    }
}
