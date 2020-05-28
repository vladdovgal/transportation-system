package com.dovhal.dao;

import com.dovhal.model.Entity;
import com.dovhal.model.LogItem;
import com.dovhal.util.DBConnectionUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogDaoImpl implements ReadOnlyEntityDao {
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
        }
        return logItems;
    }
}
