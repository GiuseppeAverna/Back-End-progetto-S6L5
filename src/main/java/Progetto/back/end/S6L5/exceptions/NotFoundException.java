package Progetto.back.end.S6L5.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id) {
        super("elemento con id" + id + "non trovato");
    }

}
