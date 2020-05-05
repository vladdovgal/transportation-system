package com.dovhal;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class App
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.warn("Test from main");
        logger.info("Test from main");
    }
}