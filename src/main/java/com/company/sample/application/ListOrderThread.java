package com.company.sample.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListOrderThread extends Thread {
    private volatile boolean exit = false;

    /**
     * Resolution: uncomment the following line to see how this improves the profile.
     */
//    private  static DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance();
//    private  static DateFormat myFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", dateFormatSymbols);
//    private  static DateFormat todayFormat = new SimpleDateFormat("dd MMM yyyy", dateFormatSymbols);
    /**
     * Here DateFormatSymbols are not provided to the SimpleDateFormat constructor and it will look up on every call, comment the below lines
     */
    private static DateFormat myFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
    private static DateFormat todayFormat = new SimpleDateFormat("dd MMM yyyy");

    private static String today = null;

    @Override
    public void run() {
        while (!exit) {
            listOrders();

        }
    }

    /**
     * List the same day orders
     */
    private void listOrders(){
        ObjectMapper objectMapper = new ObjectMapper();

        synchronized (SalesSystem.orders) {
            for(Date orderDate: SalesSystem.orders.keySet()){
                try {
                    objectMapper.setDateFormat(myFormat);
                    Date todayDate = todayFormat.parse(this.today);
                    if(Util.isSameDay(orderDate, todayDate)) {
                        String orderAsString = objectMapper.writeValueAsString(SalesSystem.orders.get(orderDate));
                    }
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setDate(String today){
        this.today = today;
    }

}

