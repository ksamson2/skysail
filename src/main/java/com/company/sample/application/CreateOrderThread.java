package com.company.sample.application;

import com.google.common.base.Optional;
import java.util.Date;
import java.util.Random;

public class CreateOrderThread extends Thread{

    static int id = 0;

    private volatile boolean exit = false;

    private static Random random = new Random();

    public void run() {
        while (!exit) {
            createOrder("APPLE");
            createOrder("ORANGE");
            createOrder("PINEAPPLE");
        }

    }

    /**
     * Create random orders
     * @param productName
     */
    public void createOrder(String productName){
        try {
            Date orderDate = Util.getRandomDate();
            Optional<ProductName> optional = ProductName.getProductName(productName);
            if (!optional.isPresent()) {
                return;
            }
            ProductName enumProductName = optional.get();

            Order order = new Order(enumProductName, orderDate, random.nextDouble() * 10000, id);

            synchronized (SalesSystem.orders) {

                if (SalesSystem.orders.size() > 10000) {
                    SalesSystem.orders.clear();
                    id = 0;
                }
                SalesSystem.orders.put(orderDate, order);
                id++;
            }
        } catch (IllegalArgumentException e){
            //e.printStackTrace();
            //not showing exception stack trace here because it will wash away SkySail's running log
        }
    }

}
