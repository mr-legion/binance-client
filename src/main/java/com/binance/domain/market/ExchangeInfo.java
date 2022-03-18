package com.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * Exchange information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {

    private String timezone;

    private Long serverTime;

    private List<Object> rateLimits;
    private List<Object> exchangeFilters;

    @JsonProperty("symbols")
    private List<MarketInfo> markets;

}
