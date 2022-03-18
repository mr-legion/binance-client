package com.binance.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * API authentication information.
 */
@RequiredArgsConstructor
@Getter
@ToString(exclude = "secret")
@EqualsAndHashCode
public class ApiCredentials {
    private final String apiKey;
    private final String secret;
}
