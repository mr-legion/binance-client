package com.binance;

import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;

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

    // Account endpoints

    /**
     * Get user balances of all assets.
     *
     * @return user balances
     */
    List<Balance> getWallet();

}