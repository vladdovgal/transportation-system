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

public class LogDaoImpl implements ReadOnlyEntityDao {
    static Logger logger = LogManager.getLogger(LogDaoImpl.class);

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
