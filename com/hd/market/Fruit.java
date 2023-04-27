package com.hd.market;

public class Fruit {
    public final static double APPLE_PRICE = 8;
    public final static double STRAWBEREY_PRICE = 13;
    public final static double MANGO_PRICE = 20;
    private boolean isDiscount = false;
    private boolean isReduce = false;

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        this.isDiscount = discount;
    }

    public boolean isReduce() {
        return isReduce;
    }

    public void setReduce(boolean reduce) {
        this.isReduce = reduce;
    }
}
