package com.binance;

import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;
import com.binance.domain.market.MarketTicker;
import com.binance.domain.market.OrderBook;

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

    /**
     * Get order book for the market.
     *
     * @param market market symbol (e.g. ETHBTC)
     * @param limit  depth of the order book. Valid limits: [5, 10, 20, 50, 100, 500, 1000, 5000]
     * @return order book
     */
    OrderBook getOrderBook(String market, Integer limit);

    // Account endpoints

    /**
     * Get user balances of all assets.
     *
     * @return user balances
     */
    List<Balance> getWallet();

}