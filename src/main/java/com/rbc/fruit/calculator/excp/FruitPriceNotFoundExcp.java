package com.rbc.fruit.calculator.excp;

/**
 * Custom Exception Class
 */
public class FruitPriceNotFoundExcp extends RuntimeException{

   public FruitPriceNotFoundExcp(){

    }
    public FruitPriceNotFoundExcp(final String message) {
        super(message);
    }


}
