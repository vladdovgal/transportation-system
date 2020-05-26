package com.dovhal;

import com.dovhal.model.City;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("Lviv".substring(0,2).toUpperCase());
    }
}