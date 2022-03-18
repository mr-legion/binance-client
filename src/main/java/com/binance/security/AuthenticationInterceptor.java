package com.binance.security;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import static com.binance.constant.BinanceApiConstants.API_KEY_HEADER;
import static com.binance.constant.BinanceApiConstants.AUTHORIZATION_REQUIRED;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final ApiCredentials apiCredentials;

    public AuthenticationInterceptor(ApiCredentials apiCredentials) {
        this.apiCredentials = apiCredentials;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isAuthorizationRequired = original.header(AUTHORIZATION_REQUIRED) != null;
        newRequestBuilder.removeHeader(AUTHORIZATION_REQUIRED);

        // Endpoint requires authorization
        if (isAuthorizationRequired) {
            newRequestBuilder.addHeader(API_KEY_HEADER, apiCredentials.getApiKey());
            String payload = original.url().query();
            if (!StringUtils.isEmpty(payload)) {
                String signature = HmacSHA256Signer.sign(payload, apiCredentials.getSecret());
                HttpUrl signedUrl = original.url().newBuilder()
                        .addQueryParameter("signature", signature)
                        .build();
                newRequestBuilder.url(signedUrl);
            }
            newRequestBuilder.tag(String.class, apiCredentials.getApiKey());
        }

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }
}