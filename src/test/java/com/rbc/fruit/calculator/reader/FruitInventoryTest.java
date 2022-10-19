package com.rbc.fruit.calculator.reader;

import com.rbc.fruit.calculator.inventory.FruitInventory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FruitInventoryTest {

    @Test
    public void addItemTest() {
        final FruitInventory fruitInventory = new FruitInventory();
        fruitInventory.addItem("Apples", 3);
        fruitInventory.addItem("Oranges", 5);
        fruitInventory.addItem("Apples", 12);
        final Map<String, Integer> allItems = fruitInventory.getAllFruits();
        assertEquals(2, allItems.size());
        assertEquals(15, allItems.get("Apples").intValue());
        assertEquals(5, allItems.get("Oranges").intValue());
    }


}
