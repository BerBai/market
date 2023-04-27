package com.hd.market;


import java.math.BigDecimal;

import static com.hd.market.Fruit.*;

public class Main {

    static Fruit fruit = new Fruit();

    public static void main(String[] args) {


        // 无则扣、满减
        double price = computeTotalPrice(1, 2, 0);
        System.out.println("价格：" + price);
        compute(fruit, price);

        // 开启折扣
        fruit.setDiscount(true);
        price = computeTotalPrice(1, 2, 3);
        System.out.println("价格：" + price);
        compute(fruit, price);

        // 开启满减
        fruit.setReduce(true);
        price = computeTotalPrice(1, 2, 4);
        System.out.println("价格：" + price);
        compute(fruit, price);

        // 测试
        test();
    }

    /**
     * 测试
     */
    private static void test() {
        compute(fruit, 100);
        compute(fruit, 99.99);
        compute(fruit, 101);
        compute(fruit, 0.01);
        compute(fruit, -1);
        compute(fruit, 125);
    }

    /**
     * 计算促销活动后的价格
     *
     * @param fruit 促销活动信息
     * @param price 商品总价
     */
    private static void compute(Fruit fruit, double price) {
        if (price < 0) {
            System.out.println("价格不能小于0");
            System.out.println("------------");
            return;
        }
        // 折扣策略
        if (fruit.isDiscount()) {
            StrategyContext context = new StrategyContext();
            context.setStrategy(new DiscountStrategy());
            price = context.computePrice(price);
        }
        // 满减策略
        if (fruit.isReduce()) {
            StrategyContext context = new StrategyContext();
            context.setStrategy(new ReduceStrategy());
            price = context.computePrice(price);
        }
        System.out.println("实付价格：" + price);
        System.out.println("------------");
    }

    /**
     * 计算总价格
     *
     * @param appleValue      apple数量
     * @param strawberryValue 草莓数量
     * @param mangoValue      芒果数量
     * @return
     */
    private static double computeTotalPrice(double appleValue, double strawberryValue, double mangoValue) {
        BigDecimal apple = toBigDecimal(APPLE_PRICE).multiply(toBigDecimal(appleValue));
        BigDecimal strawberry = toBigDecimal(STRAWBEREY_PRICE).multiply(toBigDecimal(strawberryValue));
        BigDecimal mango = toBigDecimal(MANGO_PRICE).multiply(toBigDecimal(mangoValue));
        return apple.add(strawberry).add(mango).doubleValue();
    }

    private static BigDecimal toBigDecimal(double value) {
        return new BigDecimal(String.valueOf(value));
    }
}
