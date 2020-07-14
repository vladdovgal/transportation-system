package com.dovhal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <h1> DBConnectionUtility </h1>
 * DBConnectionUtility is class which implements feature of connecting to MySQL database
 * Implements Singleton pattern.
 */
public class DBConnectionUtility {
    public static Logger logger = LogManager.getLogger(DBConnectionUtility.class);

    // returns connection to MySQL DB
    public static Connection getDBConnection() {
        Connection result = null;
        // required parameters to get connection
        String DB_CONN_URL = "jdbc:mysql://localhost:3306/transportation" +
                "?useUnicode=true&serverTimezone=UTC&useSSL=false";
        String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"; // remove "cj" if using 7 ore lower MYSQL version
        String USER_NAME = "root";
        String USER_PASSWORD = "Skleroz123_";

        // parameters for Heroku
/*
        String DB_CONN_URL = "jdbc:mysql://zpfp07ebhm2zgmrm.chr7pe7iynqr.eu-west-1.rds.amazonaws.com\t:3306/xfdiqt2877rvhvan" +
                "?useUnicode=true&serverTimezone=UTC&useSSL=false";
        String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"; // remove "cj" if using 7 ore lower MYSQL version
        String USER_NAME = "snhuffkglmfaqw1s";
        String USER_PASSWORD = "xjj3rgj5s45944vj";
*/

        try {
            Class.forName(DRIVER_CLASS_NAME).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            errorLog("Can't get JDBC Driver :" + e.getMessage());
        }

        // getting connection
        try {
            result = DriverManager.getConnection(DB_CONN_URL, USER_NAME, USER_PASSWORD);
            traceLog("Successfully connected to Database!");
        } catch (SQLException e) {
            e.printStackTrace();
            errorLog("Can't connect to DB :" + e.getMessage());
        }

        return result;
    }

    // logging errors
    private static void errorLog(String message) {
        logger.error(message + " | See stacktrace in Console!");
    }

    private static void traceLog(String message) {
        logger.trace(message);
    }
}
