package com.binance.impl;

import com.binance.BinanceApiError;
import com.binance.exception.BinanceApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.binance.impl.BinanceApiServiceGenerator.getBinanceApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                BinanceApiError apiError = getBinanceApiError(response);
                onFailure(call, new BinanceApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new BinanceApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof BinanceApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new BinanceApiException(t));
        }
    }
}
