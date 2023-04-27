package com.hd.market;


public interface SellStrategy {
    /**
     * 促销策略
     *
     * @param totalPrice 总价
     * @return
     */
    double payPrice(double totalPrice);
}
