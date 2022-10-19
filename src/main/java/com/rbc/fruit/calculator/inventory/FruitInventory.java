package com.rbc.fruit.calculator.inventory;

import java.util.HashMap;
import java.util.Map;
/**
 * This class is to define the fruit inventory
 */
public class FruitInventory {

    private final Map<String, Integer> itemQuantityMap = new HashMap<>();

    public void addItem(final String item, final int quantity) {
        int newCount = quantity;
        if (itemQuantityMap.containsKey(item)) {
            final int currentCount = itemQuantityMap.get(item);
            newCount += currentCount;
        }
            itemQuantityMap.put(item, newCount);
    }

    public Map<String, Integer> getAllFruits() {
        final Map<String, Integer> fruitInventory = new HashMap<>();
        fruitInventory.putAll(itemQuantityMap);
        return fruitInventory;
    }
}
