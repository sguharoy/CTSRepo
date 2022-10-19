package com.rbc.fruit.calculator;

import com.rbc.fruit.calculator.driver.FruitPriceCalculatorDriver;
import com.rbc.fruit.calculator.excp.FruitPriceNotFoundExcp;
import com.rbc.fruit.calculator.inventory.FruitInventory;
import com.rbc.fruit.calculator.provider.FruitItemPriceProvider;
import com.rbc.fruit.calculator.provider.FruitItemPriceProviderImpl;
import org.junit.Test;

import java.util.HashMap;
import static org.junit.Assert.assertTrue;

public class FruitPriceCalculatorDriverTest {

    @Test
    public void getTotalCost(){
        final FruitInventory fruitInventory=new FruitInventory();
        fruitInventory.addItem("Apples",2);
        fruitInventory.addItem("Oranges",3);
        final FruitItemPriceProvider fipp = new FruitItemPriceProviderImpl(new HashMap<String, Double>() {
            {
                put("Oranges", 5.75);
                put("Apples", 20.75);
            }
        });
        final FruitPriceCalculatorDriver fruitPriceCalculatorDriver=new FruitPriceCalculatorDriver();
        final double totalPrice=fruitPriceCalculatorDriver.getTotalCost(fruitInventory,fipp);
        assertTrue(Double.compare(58.75, totalPrice) == 0);
    }
    @Test(expected = FruitPriceNotFoundExcp.class)
    public void getTotalCostNegativeTest() {
        final FruitInventory fruitInventory=new FruitInventory();
        fruitInventory.addItem("Apples",2);
        fruitInventory.addItem("Oranges",3);
        final FruitItemPriceProvider fipp = new FruitItemPriceProviderImpl(new HashMap<String, Double>() {
            {
                put("Oranges", 5.75);
                put("Peanuts", 20.75);
            }
        });
        final FruitPriceCalculatorDriver fruitPriceCalculatorDriver=new FruitPriceCalculatorDriver();
       fruitPriceCalculatorDriver.getTotalCost(fruitInventory,fipp);
    }
}
