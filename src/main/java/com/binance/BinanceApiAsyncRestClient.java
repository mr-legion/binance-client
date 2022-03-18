package com.binance;

import com.binance.domain.account.Balance;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Binance API facade, supporting asynchronous/non-blocking access Binance's REST API.
 */
public interface BinanceApiAsyncRestClient {

    // Account endpoints

    /**
     * Get user balances of all assets (asynchronous).
     *
     * @return user balances
     */
    CompletableFuture<List<Balance>> getWallet();

}