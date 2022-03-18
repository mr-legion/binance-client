package com.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Market types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketType {
    SPOT,
    MARGIN,
    LEVERAGED,
    TRD_GRP_003
}
