package com.binance.impl;

import com.binance.BinanceApiAsyncRestClient;
import com.binance.BinanceApiClientFactory;
import com.binance.domain.account.Balance;
import com.binance.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BinanceApiAsyncRestClientImplTest {

    private BinanceApiAsyncRestClient binanceApiAsyncRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.binanceApiAsyncRestClient = BinanceApiClientFactory.newInstance(apiCredentials).newAsyncRestClient();
    }

    @Test
    public void getWallet_ShouldReturnUserWallet() throws ExecutionException, InterruptedException {
        List<Balance> wallet = binanceApiAsyncRestClient.getWallet().get();
        assertThat(wallet, allOf(notNullValue(), is(not(empty()))));
    }
}