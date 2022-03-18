package com.binance.security;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_256;

/**
 * Utility class to sign messages using HMAC-SHA256.
 */
@UtilityClass
public class HmacSHA256Signer {

    /**
     * Sign the given message using the given secret.
     *
     * @param message message to sign
     * @param secret  secret key
     * @return a signed message
     */
    public static String sign(String message, String secret) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), HMAC_SHA_256.getName());
            Mac sha256_HMAC = Mac.getInstance(HMAC_SHA_256.getName());
            sha256_HMAC.init(secretKeySpec);
            return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes(UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message", e);
        }
    }
}
