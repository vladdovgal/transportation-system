package com.dovhal.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtility {
    public static Connection getDBConnection(){
        Connection result = null;

        String DB_CONN_URL = "jdbc:mysql://localhost:3306/transportation" +
                "?useUnicode=true&serverTimezone=UTC&useSSL=false";

        String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"; // remove "cj" if using 7 ore lower MYSQL version

        String USER_NAME = "root";

        String USER_PASSWORD = "Skleroz123_";

        try {
            Class.forName(DRIVER_CLASS_NAME).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace(); //replace with logging
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            result = DriverManager.getConnection(DB_CONN_URL,USER_NAME,USER_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Can't connect to DB");
        }

        return result;
    }

    private static void log(Object eObject){
        // write logging (Log4J)
    }
}
