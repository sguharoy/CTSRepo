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
    public FruitPriceNotFoundExcp(final Throwable cause) {
        super(cause);
    }

    public FruitPriceNotFoundExcp(final String message, final Throwable cause) {
        super(message, cause);
    }


}
