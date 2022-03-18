package com.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Order types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderType {
    LIMIT,
    LIMIT_MAKER,
    MARKET,
    STOP_LOSS,
    STOP_LOSS_LIMIT,
    TAKE_PROFIT,
    TAKE_PROFIT_LIMIT
}
