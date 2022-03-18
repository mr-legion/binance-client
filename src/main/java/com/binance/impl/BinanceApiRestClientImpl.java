package com.binance.impl;

import com.binance.BinanceApiRestClient;
import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;
import com.binance.domain.market.MarketTicker;

import java.time.Instant;
import java.util.List;

import static com.binance.constant.BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
import static com.binance.impl.BinanceApiServiceGenerator.executeSync;

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
public class BinanceApiRestClientImpl implements BinanceApiRestClient {

    private final BinanceApiService binanceApiService;

    public BinanceApiRestClientImpl(BinanceApiService binanceApiService) {
        this.binanceApiService = binanceApiService;
    }

    // Market endpoints

    @Override
    public ExchangeInfo getExchangeInfo() {
        return executeSync(binanceApiService.getExchangeInfo());
    }

    @Override
    public List<MarketTicker> getMarketTickers() {
        return executeSync(binanceApiService.getMarketTickers());
    }

    // Account endpoints

    @Override
    public List<Balance> getWallet() {
        return executeSync(binanceApiService.getWallet(DEFAULT_RECEIVING_WINDOW, Instant.now().toEpochMilli()));
    }
}
