package com.dovhal.dao;

import com.dovhal.model.Entity;
import com.dovhal.model.LogItem;
import com.dovhal.util.DBConnectionUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * LogDaoImpl.java is a class, which implements ReadOnlyEntityDao
 * It is used for implementation of Reading and Deleting logs feature
 * Logs are automatically written to database (using LOG4J 2)
 *
 * @author vladd
 * @version 1.0
 */
public class LogDaoImpl implements ReadOnlyEntityDao {
    static Logger logger = LogManager.getLogger(LogDaoImpl.class);

    /**
     * <h3> Method designed for getting list of all logs from LOGS table. </h3>
     *
     * @return list of all logs
     */
    @Override
    public List<? extends Entity> getAllEntities() {
        List<LogItem> logItems = new ArrayList<>();
        try(Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM LOGS ORDER BY DATED DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                LogItem log = new LogItem();
                log.setDated(resultSet.getString("DATED"));
                log.setLogger(resultSet.getString("LOGGER"));
                log.setLevel(resultSet.getString("LEVEL"));
                log.setMessage(resultSet.getString("MESSAGE"));
                logItems.add(log);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("SQL Exception was caught. See stacktrace in console");
        }
        return logItems;
    }

    /**
     * <h3> Method designed for clearing all data in LOGS table </h3>
     */
    public void clearLogs() {
        try(Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "TRUNCATE TABLE LOGS";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            logger.debug("All logs were cleaned");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("SQL Exception was caught. See stacktrace in console");
        }
    }
}
