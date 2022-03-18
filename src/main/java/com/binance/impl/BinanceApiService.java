package com.binance.impl;

import com.binance.domain.account.Balance;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

import static com.binance.constant.BinanceApiConstants.AUTHORIZATION_REQUIRED_HEADER;

/**
 * Binance's REST API URL mappings.
 */
public interface BinanceApiService {

    // Account endpoints

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @GET("/sapi/v1/capital/config/getall")
    Call<List<Balance>> getWallet(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

}
