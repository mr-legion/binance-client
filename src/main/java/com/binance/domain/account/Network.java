package com.binance.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Network information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

    @JsonProperty("network")
    private String chain;

    private String name;

    @JsonProperty("coin")
    private String asset;

    @JsonProperty("isDefault")
    private Boolean main;

    @JsonProperty("depositEnable")
    private Boolean depositEnabled;

    @JsonProperty("withdrawEnable")
    private Boolean withdrawEnabled;

    private Integer minConfirm;
    private Integer unLockConfirm;

    private Double withdrawFee;

    @JsonProperty("withdrawMin")
    private Double minWithdraw;

    @JsonProperty("withdrawMax")
    private Double maxWithdraw;

    @JsonProperty("withdrawIntegerMultiple")
    private Double withdrawMultiple;

    private String specialTips;
    private String depositDesc;
    private String addressRegex;
    private String memoRegex;

    private String withdrawDesc;

    private Boolean resetAddressStatus;
    private Boolean sameAddress;

}
