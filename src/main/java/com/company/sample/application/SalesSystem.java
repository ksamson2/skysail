package com.company.sample.application;

import com.amazonaws.skysailprivatebeta.agent.Profiler;
import com.amazonaws.skysailprivatebeta.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class SalesSystem {

    public static ConcurrentHashMap<Date, Order> orders = new ConcurrentHashMap<Date, Order>();

    public static void main(String[] args) {
        //Start the profiler
        Profiler systemProfiler = new Profiler("<Insert the profiling group name here>", DefaultAWSCredentialsProviderChain.getInstance());
        systemProfiler.start();

        //Start create order thread
        CreateOrderThread createOrderThread = new CreateOrderThread();
        createOrderThread.start();

        //Start create Illegal order thread
        CreateIllegalOrderThread createIllegalOrderThread = new CreateIllegalOrderThread();
        createIllegalOrderThread.start();

        //Start list order thread
        ListOrderThread listOrderThread = new ListOrderThread();

        DateFormat currentDateFormat = new SimpleDateFormat("dd MMM yyyy");
        listOrderThread.setDate(currentDateFormat.format(new Date()));

        listOrderThread.start();
    }
}
