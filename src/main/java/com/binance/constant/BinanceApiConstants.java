package com.binance.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout Binance's API.
 */
@UtilityClass
public class BinanceApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "binance.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api." + BASE_DOMAIN;

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "X-MBX-APIKEY";

    /**
     * Decorator to indicate that an endpoint requires authorization.
     */
    public static final String AUTHORIZATION_REQUIRED = "AUTHORIZATION";
    public static final String AUTHORIZATION_REQUIRED_HEADER = AUTHORIZATION_REQUIRED + ": #";

    public static final long DEFAULT_RECEIVING_WINDOW = 60_000L;
}
