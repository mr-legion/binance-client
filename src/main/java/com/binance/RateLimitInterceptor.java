package com.binance;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Interceptor used to limit the number of requests per second.
 */
public class RateLimitInterceptor implements Interceptor {

    private final long minRequestInterval;
    private final long minApiKeyUsageInterval;

    private final Map<String, Long> lastTimeByApiKeyUsage = new HashMap<>();

    private long lastRequestTime = 0;

    public RateLimitInterceptor(double maxRequestsPerSecond, double maxApiKeyUsagePerSecond) {
        this.minRequestInterval = (long) (1 / maxRequestsPerSecond * 1000);
        this.minApiKeyUsageInterval = (long) (1 / maxApiKeyUsagePerSecond * 1000);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Response intercept(Chain chain) throws IOException {

        String apiKey = chain.request().tag(String.class);

        while (!chain.call().isCanceled()) {

            long sleepingTime;

            synchronized (this) {

                long currentTime = Instant.now().toEpochMilli();

                long timeSinceLastRequest = currentTime - lastRequestTime;
                boolean isMinRequestIntervalExceeded = timeSinceLastRequest < minRequestInterval;

                if (!isMinRequestIntervalExceeded && apiKey != null) {

                    long lastTimeApiKeyUsage = lastTimeByApiKeyUsage.getOrDefault(apiKey, 0L);
                    long timeSinceLastApiKeyUsage = currentTime - lastTimeApiKeyUsage;

                    if (timeSinceLastApiKeyUsage >= minApiKeyUsageInterval) {
                        lastRequestTime = currentTime;
                        lastTimeByApiKeyUsage.put(apiKey, currentTime);
                        break;
                    }

                    sleepingTime = minApiKeyUsageInterval - timeSinceLastApiKeyUsage;
                } else if (!isMinRequestIntervalExceeded) {
                    lastRequestTime = currentTime;
                    break;
                } else {
                    sleepingTime = minRequestInterval - timeSinceLastRequest;
                }
            }

            sleep(sleepingTime);
        }

        return chain.proceed(chain.request());
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
