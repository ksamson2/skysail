package com.company.sample.application;

public class CreateIllegalOrderThread extends CreateOrderThread{

    private volatile boolean exit = false;

    public void run() {
        while (!exit) {
            //some illegal product names
            createOrder("MANGO");
            createOrder("STRAWBERRY");
            createOrder("BANANA");
            createOrder("GRAPE");
            createOrder("CHERRY");
        }

    }
}
