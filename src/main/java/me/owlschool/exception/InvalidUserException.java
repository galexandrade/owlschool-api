package me.owlschool.exception;

/**
 * Created by Alex P. Andrade on 29/06/2017.
 */
public class InvalidUserException extends AppException {
    private static final long serialVersionUID = 7847759689516569076L;

    /**
     * Empty constructor with the default localized message
     */
    public InvalidUserException() {
        super("app.exception.InvalidUserException");
    }
}
