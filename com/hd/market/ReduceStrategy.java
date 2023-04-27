package com.hd.market;

import java.math.BigDecimal;

public class ReduceStrategy implements SellStrategy {
    @Override
    public double payPrice(double totalPrice) {
        if (totalPrice >= 100.0) {
            System.out.println("满减 -10");
            BigDecimal price = new BigDecimal(String.valueOf(totalPrice));
            BigDecimal reduceMoney = new BigDecimal(10);
            return price.subtract(reduceMoney).doubleValue();
        }
        return totalPrice;
    }
}
