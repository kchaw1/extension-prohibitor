package com.extprohibit.global.exeption;

public class DuplicatedCustomExtensionException extends RuntimeException{
    public DuplicatedCustomExtensionException() {
        super();
    }

    public DuplicatedCustomExtensionException(String message) {
        super(message);
    }

    public DuplicatedCustomExtensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedCustomExtensionException(Throwable cause) {
        super(cause);
    }

    protected DuplicatedCustomExtensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
