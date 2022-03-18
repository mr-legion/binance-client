package com.binance.domain.market;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Custom deserializer for an Order, since the API returns an array in the format [price, qty].
 */
public class OrderDeserializer extends JsonDeserializer<Order> {

    @Override
    public Order deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        final Double price = node.get(0).asDouble();
        final Double qty = node.get(1).asDouble();
        return new Order(price, qty);
    }
}
