package com.binance.impl;

import com.binance.BinanceApiAsyncRestClient;
import com.binance.domain.account.Balance;

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

    // Account endpoints

    @Override
    public CompletableFuture<List<Balance>> getWallet() {
        CompletableFuture<List<Balance>> future = new CompletableFuture<>();
        binanceApiService.getWallet(DEFAULT_RECEIVING_WINDOW, Instant.now().toEpochMilli())
                .enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
