package com.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An order.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonDeserialize(using = OrderDeserializer.class)
@JsonSerialize(using = OrderSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private Double price;
    private Double quantity;
}
