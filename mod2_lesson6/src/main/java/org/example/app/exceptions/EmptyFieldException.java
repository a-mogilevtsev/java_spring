package org.example.app.exceptions;

/**
 * Created by a.sosnina on 12/8/2022.
 */
public class EmptyFieldException extends Exception {

    private final String message;

    public EmptyFieldException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
