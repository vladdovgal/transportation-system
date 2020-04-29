package com.dovhal;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class App
{
    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        // PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("log4j2.properties");

        // Log in console
        logger.debug("Log4j console appender configuration is successful !!");
    }
}