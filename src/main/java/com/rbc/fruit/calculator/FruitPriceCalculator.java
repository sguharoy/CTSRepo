package com.rbc.fruit.calculator;

import com.rbc.fruit.calculator.inventory.FruitInventory;
import com.rbc.fruit.calculator.provider.FruitItemPriceProvider;
import java.util.stream.Collectors;


/**
 * Calculator class for the entire fruit price calculator application
 */
public class FruitPriceCalculator {


    public double getTotalCost(final FruitInventory fruitInventory, final FruitItemPriceProvider fruitItemPriceProvider) {
        System.out.println("Using the predefined prices for each fruit item");
        return fruitInventory.getAllFruits().entrySet().stream().collect(Collectors.reducing(0.0, (entry) -> {
            return fruitItemPriceProvider.getPriceForFruit(entry.getKey()) * entry.getValue();
        }, Double::sum));


    }
}
