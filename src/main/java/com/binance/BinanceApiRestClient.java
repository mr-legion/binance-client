package com.binance;

import com.binance.domain.account.Balance;

import java.util.List;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BinanceApiRestClient {

    // Account endpoints

    /**
     * Get user balances of all assets.
     *
     * @return user balances
     */
    List<Balance> getWallet();

}