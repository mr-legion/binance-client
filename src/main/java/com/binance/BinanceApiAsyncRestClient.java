package com.binance;

import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;

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

    // Account endpoints

    /**
     * Get user balances of all assets (asynchronous).
     *
     * @return user balances
     */
    CompletableFuture<List<Balance>> getWallet();

}