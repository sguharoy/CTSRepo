package com.rbc.fruit.calculator.provider;

import com.rbc.fruit.calculator.excp.FruitPriceNotFoundExcp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of FruitItemPriceProvider that just looks up for
 * fruit prices in a hashmap.
 */
public class FruitItemPriceProviderImpl implements FruitItemPriceProvider {
    private final Map<String, Double> itemPriceMap;

    public FruitItemPriceProviderImpl(final Map<String, Double> priceMap) {
        if (null == priceMap) {
            throw new IllegalArgumentException("itemPriceMap cannot be null!");
        }

        this.itemPriceMap = new HashMap<>();
        itemPriceMap.putAll(priceMap);
    }

    @Override
    public double getPriceForFruit(String item) {
        if (null == item) {
            throw new IllegalArgumentException("fruit item cannot be null!");
        }
        if (itemPriceMap.containsKey(item)) {
            return itemPriceMap.get(item);
        }
        throw new FruitPriceNotFoundExcp("Could not find price for fruit item: " + item);
    }
}
