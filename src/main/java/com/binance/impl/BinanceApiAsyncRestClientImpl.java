package com.binance.impl;

import com.binance.BinanceApiAsyncRestClient;
import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;
import com.binance.domain.market.MarketTicker;
import com.binance.domain.market.OrderBook;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.binance.constant.BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;

/**
 * Implementation of Binance's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiAsyncRestClientImpl implements BinanceApiAsyncRestClient {

    private final BinanceApiService binanceApiService;

    public BinanceApiAsyncRestClientImpl(BinanceApiService binanceApiService) {
        this.binanceApiService = binanceApiService;
    }

    // Market endpoints

    @Override
    public CompletableFuture<ExchangeInfo> getExchangeInfo() {
        CompletableFuture<ExchangeInfo> future = new CompletableFuture<>();
        binanceApiService.getExchangeInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<List<MarketTicker>> getMarketTickers() {
        CompletableFuture<List<MarketTicker>> future = new CompletableFuture<>();
        binanceApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<OrderBook> getOrderBook(String market, Integer limit) {
        CompletableFuture<OrderBook> future = new CompletableFuture<>();
        binanceApiService.getOrderBook(market, limit).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Account endpoints

    @Override
    public CompletableFuture<List<Balance>> getWallet() {
        CompletableFuture<List<Balance>> future = new CompletableFuture<>();
        binanceApiService.getWallet(DEFAULT_RECEIVING_WINDOW, Instant.now().toEpochMilli())
                .enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
