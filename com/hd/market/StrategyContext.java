package com.hd.market;

import java.math.BigDecimal;

public class StrategyContext {
    private SellStrategy strategy;

    public void setStrategy(SellStrategy strategy) {
        this.strategy = strategy;
    }

    public double computePrice(double consumePrice) {
        double price = this.strategy.payPrice(consumePrice);
        return price;
    }
}
