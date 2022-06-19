package com.extprohibit.global.exeption;

public class MaxCustomCountEcxeedException extends RuntimeException{
    public MaxCustomCountEcxeedException() {
        super();
    }

    public MaxCustomCountEcxeedException(String message) {
        super(message);
    }

    public MaxCustomCountEcxeedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxCustomCountEcxeedException(Throwable cause) {
        super(cause);
    }

    protected MaxCustomCountEcxeedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
