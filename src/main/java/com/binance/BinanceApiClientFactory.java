package com.binance;

import com.binance.impl.BinanceApiAsyncRestClientImpl;
import com.binance.impl.BinanceApiRestClientImpl;
import com.binance.impl.BinanceApiService;
import com.binance.impl.BinanceApiServiceGenerator;
import com.binance.security.ApiCredentials;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Binance API client objects.
 */
public class BinanceApiClientFactory {

    private final BinanceApiServiceGenerator serviceGenerator;

    private final ApiCredentials apiCredentials;

    public BinanceApiClientFactory() {
        this(new OkHttpClient(), null);
    }

    public BinanceApiClientFactory(ApiCredentials apiCredentials) {
        this(new OkHttpClient(), apiCredentials);
    }

    private BinanceApiClientFactory(OkHttpClient client, ApiCredentials apiCredentials) {
        this.serviceGenerator = new BinanceApiServiceGenerator(client);
        this.apiCredentials = apiCredentials;
    }

    /**
     * New instance without authentication.
     *
     * @return the Binance API client factory
     */
    public static BinanceApiClientFactory newInstance() {
        return new BinanceApiClientFactory();
    }

    /**
     * New instance with authentication.
     *
     * @return the Binance API client factory
     */
    public static BinanceApiClientFactory newInstance(ApiCredentials apiCredentials) {
        return new BinanceApiClientFactory(apiCredentials);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BinanceApiRestClient newRestClient() {
        return new BinanceApiRestClientImpl(serviceGenerator.createService(BinanceApiService.class, apiCredentials));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BinanceApiAsyncRestClient newAsyncRestClient() {
        return new BinanceApiAsyncRestClientImpl(serviceGenerator.createService(BinanceApiService.class, apiCredentials));
    }
}
