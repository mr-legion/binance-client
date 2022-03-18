package com.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String symbol;

    private String baseAsset;
    private String quoteAsset;

    private MarketStatus status;

    @JsonProperty("permissions")
    private List<MarketType> types;

    private Integer baseAssetPrecision;
    private Integer quotePrecision;
    private Integer quoteAssetPrecision;

    private OrderType orderType;

    private Boolean icebergAllowed;
    private Boolean ocoAllowed;
    private Boolean quoteOrderQtyMarketAllowed;
    private Boolean allowTrailingStop;

    @JsonProperty("isSpotTradingAllowed")
    private Boolean spotTradingAllowed;

    @JsonProperty("isMarginTradingAllowed")
    private Boolean marginTradingAllowed;

    private List<Object> filters;

}
