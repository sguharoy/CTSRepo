package com.rbc.fruit.calculator;

import com.rbc.fruit.calculator.inventory.FruitInventory;
import com.rbc.fruit.calculator.provider.FruitItemPriceProvider;


/**
 * Calculator class for the entire fruit price calculator application
 */
public class FruitPriceCalculator {

    private double total = 0.0;


    public double getTotalCost(final FruitInventory fruitInventory, final FruitItemPriceProvider fruitItemPriceProvider) {
        System.out.println("Using the predefined prices for each fruit item");
        fruitInventory.getAllFruits().entrySet().forEach(entry -> {
            total += fruitItemPriceProvider.getPriceForFruit(entry.getKey()) * entry.getValue();
            System.out.println(String.format("%s: $%.2f (%d items)", entry.getKey(), fruitItemPriceProvider.getPriceForFruit(entry.getKey()),
                    entry.getValue()));
        });
        return total;

    }
}
