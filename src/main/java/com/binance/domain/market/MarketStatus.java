package com.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    PRE_TRADING,
    TRADING,
    POST_TRADING,
    END_OF_DAY,
    HALT,
    AUCTION_MATCH,
    BREAK;
}
