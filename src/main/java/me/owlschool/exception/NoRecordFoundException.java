package me.owlschool.exception;

/**
 * Created by Alex P. Andrade on 29/06/2017.
 */
public class NoRecordFoundException extends AppException {
    private static final long serialVersionUID = 7847759689516569076L;

    /**
     * Empty constructor with the default localized message
     */
    public NoRecordFoundException() {
        super("{app.exception.PoolNoRecordFoundException}");
    }
}
