package com.binance.impl;

import com.binance.BinanceApiClientFactory;
import com.binance.BinanceApiRestClient;
import com.binance.domain.account.Balance;
import com.binance.domain.market.ExchangeInfo;
import com.binance.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BinanceApiRestClientImplTest {

    private BinanceApiRestClient binanceApiRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.binanceApiRestClient = BinanceApiClientFactory.newInstance(apiCredentials).newRestClient();
    }

    @Test
    public void getExchangeInfo_ShouldReturnExchangeInfo() {
        ExchangeInfo exchangeInfo = binanceApiRestClient.getExchangeInfo();
        assertNotNull(exchangeInfo);
        assertThat(exchangeInfo.getMarkets(), is(not(empty())));
    }

    @Test
    public void getWallet_ShouldReturnUserWallet() {
        List<Balance> wallet = binanceApiRestClient.getWallet();
        assertThat(wallet, allOf(notNullValue(), is(not(empty()))));
    }
}