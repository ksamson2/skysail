package com.company.sample.application;
import java.util.*;

import com.amazonaws.skysailprivatebeta.agent.Profiler;
import com.amazonaws.skysailprivatebeta.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

public class App {

    public static void main(String[] args) {

        new Profiler("profile-app", DefaultAWSCredentialsProviderChain.getInstance()).start();
        App app = new App();

        while(true){
            app.load();
            Thread.sleep(4000);
            System.out.println("load finish");
            app.load1();
            System.out.println("load1 finish");
            app.load2();
            System.out.println("load2 finish");
        }
    }

    private void load() {
        for (int i =0; i< 1 << 20; ++i){
            computeShort();
        }
    }

    private void load1(){
        for (int i =0; i< 1 << 20; ++i){
            computeMedium();
        }
    }

    private void load2(){
        for (int i =0; i< 1 << 20; ++i){
            computeLong();
        }
    }

    private void computeShort(){
        long x = 0;
        for (int i =0; i< 1 << 15; ++i){
            x += i;
        }
    }

    private void computeMedium(){
        long x = 0;
        for (int i =0; i< 1 << 17; ++i){
            x += i;
        }
    }

    private void computeLong(){
        long x = 0;
        for (int i =0; i< 1 << 18; ++i){
            x += i;
        }
    }
}
