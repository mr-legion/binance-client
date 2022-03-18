package com.binance;

import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;
import com.binance.domain.market.MarketTicker;

import java.util.List;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BinanceApiRestClient {

    // Market endpoints

    /**
     * Get market information.
     *
     * @return market info
     */
    ExchangeInfo getExchangeInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    List<MarketTicker> getMarketTickers();

    // Account endpoints

    /**
     * Get user balances of all assets.
     *
     * @return user balances
     */
    List<Balance> getWallet();

}