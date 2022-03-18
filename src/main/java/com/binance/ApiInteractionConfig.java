package com.binance;

import lombok.Getter;
import lombok.ToString;

import java.net.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * Configuration for API interaction.
 */
@Getter
@ToString
public class ApiInteractionConfig {

    private final double maxRequestsPerSecond;
    private final double maxApiKeyUsagePerSecond;

    private final Set<Proxy> proxies = new HashSet<>();

    public ApiInteractionConfig(double maxRequestsPerSecond, double maxApiKeyUsagePerSecond) {
        this.maxRequestsPerSecond = maxRequestsPerSecond;
        this.maxApiKeyUsagePerSecond = maxApiKeyUsagePerSecond;
    }

    public ApiInteractionConfig(double maxRequestsPerSecond, double maxApiKeyUsagePerSecond, Set<Proxy> proxies) {
        this.maxRequestsPerSecond = maxRequestsPerSecond;
        this.maxApiKeyUsagePerSecond = maxApiKeyUsagePerSecond;
        this.proxies.addAll(proxies);
    }
}
