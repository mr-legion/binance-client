package com.binance.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * User balance information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Balance {

    @JsonProperty("coin")
    private String assetSymbol;

    @JsonProperty("name")
    private String assetName;

    @JsonProperty("isLegalMoney")
    private Boolean fiatMoney;

    @JsonProperty("trading")
    private Boolean tradingEnabled;

    private Boolean depositAllEnable;
    private Boolean withdrawAllEnable;

    private Double free;
    private Double locked;
    private Double freeze;
    private Double ipoable;
    private Double ipoing;
    private Double storage;
    private Double withdrawing;

    @JsonProperty("networkList")
    private List<Network> networks;

    public boolean isDepositEnabled() {
        return networks.stream().anyMatch(Network::getDepositEnabled);
    }

    public boolean isWithdrawEnabled() {
        return networks.stream().anyMatch(Network::getWithdrawEnabled);
    }

    public Integer getMinConfirm() {

        Integer minConfirm = null;

        for (Network network : networks) {
            Integer confirm = network.getMinConfirm();
            if (minConfirm == null || (confirm != null && confirm < minConfirm)) {
                minConfirm = confirm;
            }
        }

        return minConfirm;
    }

    public Integer getMinUnLockConfirm() {

        Integer minConfirm = null;

        for (Network network : networks) {
            Integer confirm = network.getUnLockConfirm();
            if (minConfirm == null || (confirm != null && confirm < minConfirm)) {
                minConfirm = confirm;
            }
        }

        return minConfirm;
    }

    public Double getMinFixedWithdrawFee() {

        Double minFee = null;

        for (Network network : networks) {
            Double fee = network.getWithdrawFee();
            if (minFee == null || (fee != null && fee < minFee)) {
                minFee = fee;
            }
        }

        return minFee;
    }
}
