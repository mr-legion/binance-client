package com.binance;

import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;
import com.binance.domain.market.MarketTicker;
import com.binance.domain.market.OrderBook;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Binance API facade, supporting asynchronous/non-blocking access Binance's REST API.
 */
public interface BinanceApiAsyncRestClient {

    // Market endpoints

    /**
     * Get market information (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<ExchangeInfo> getExchangeInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<List<MarketTicker>> getMarketTickers();

    /**
     * Get order book for the market (asynchronous).
     *
     * @param market market symbol (e.g. ETHBTC)
     * @param limit  depth of the order book. Valid limits: [5, 10, 20, 50, 100, 500, 1000, 5000]
     * @return order book
     */
    CompletableFuture<OrderBook> getOrderBook(String market, Integer limit);

    // Account endpoints

    /**
     * Get user balances of all assets (asynchronous).
     *
     * @return user balances
     */
    CompletableFuture<List<Balance>> getWallet();

}