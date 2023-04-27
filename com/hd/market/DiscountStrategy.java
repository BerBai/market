package com.hd.market;


import java.math.BigDecimal;

public class DiscountStrategy implements SellStrategy {

    public final static double DISCOUNT = 0.8;

    @Override
    public double payPrice(double totalPrice) {
        System.out.println("打 8 折");
        BigDecimal price = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal dis = new BigDecimal(String.valueOf(DISCOUNT));
        return price.multiply(dis).doubleValue();
    }
}
