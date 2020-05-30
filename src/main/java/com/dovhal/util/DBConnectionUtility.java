package com.dovhal.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnectionUtility {
    public static Logger logger = LogManager.getLogger(DBConnectionUtility.class);

    public static Connection getDBConnection() {
        Connection result = null;
        String DB_CONN_URL = "jdbc:mysql://localhost:3306/transportation" +
                "?useUnicode=true&serverTimezone=UTC&useSSL=false";
        String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"; // remove "cj" if using 7 ore lower MYSQL version
        String USER_NAME = "root";
        String USER_PASSWORD = "Skleroz123_";

        try {
            Class.forName(DRIVER_CLASS_NAME).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            errorLog("Can't get JDBC Driver");
        }

        try {
            result = DriverManager.getConnection(DB_CONN_URL, USER_NAME, USER_PASSWORD);
            traceLog("Successfully connected to Database!");
        } catch (SQLException e) {
            e.printStackTrace();
            errorLog("Can't connect to DB");
        }

        return result;
    }

    private static void errorLog(String message) {
        logger.error(message + " | See stacktrace in Console!");
    }

    private static void traceLog(String message) {
        logger.trace(message);
    }
}
