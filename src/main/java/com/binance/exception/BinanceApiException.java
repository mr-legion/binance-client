package com.binance.exception;

import com.binance.BinanceApiError;

/**
 * An exception which can occur while invoking methods of the Binance API.
 */
public class BinanceApiException extends RuntimeException {

    private static final long serialVersionUID = 1538558260691587402L;

    private BinanceApiError error;

    public BinanceApiException(BinanceApiError error) {
        this.error = error;
    }

    public BinanceApiException() {
        super();
    }

    public BinanceApiException(String message) {
        super(message);
    }

    public BinanceApiException(Throwable cause) {
        super(cause);
    }

    public BinanceApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Binance API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public BinanceApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
