package com.dovhal.dao;


import com.dovhal.model.City;
import com.dovhal.model.Entity;
import com.dovhal.model.Parcel;
import com.dovhal.model.Status;
import com.dovhal.util.DBConnectionUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * ParcelDaoImpl.java is a class, which implements ParcelDao
 * It is used for implementation of CRUD and other methods
 *
 * @author vladd
 * @
 */
public class ParcelDaoImpl implements EntityDao {
    static Logger  logger = LogManager.getLogger(ParcelDaoImpl.class);


    @Override
    public <T extends Entity> void createEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "INSERT INTO parcels (parcelId,senderName,recipientName,startCity,endCity,weight,status)" +
                    "VALUES (?,?,?,?,?,?,?)";
            Random random = new Random();
            int rand = Integer.parseInt(String.format("%05d", random.nextInt(99999)));
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Parcel parcel = (Parcel) entity;
            String id = parcel.getStartCity().substring(0, 2).toUpperCase()
                    + rand + parcel.getEndCity().substring(0, 2).toUpperCase();
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, parcel.getSenderName());
            preparedStatement.setString(3, parcel.getRecipientName());
            preparedStatement.setString(4, parcel.getStartCity());
            preparedStatement.setString(5, parcel.getEndCity());
            preparedStatement.setDouble(6, parcel.getWeight());
            preparedStatement.setString(7, parcel.getStatus());
            preparedStatement.executeUpdate();

            logEntityInfo("Parcel " + id + " from " + parcel.getStartCity().toString() +
                    " to " + parcel.getEndCity().toString() + " created");
        } catch (SQLException throwables) {
            daoError("SQLException was caught. Stacktrace is available in console");
            throwables.printStackTrace(); }
    }

    @Override
    public void deleteEntity(String id) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            Parcel parcel = getEntityById(id);
            String query = "DELETE FROM parcels WHERE parcelID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            logEntityInfo("Parcel " + id + " from " + parcel.getStartCity().toString() +
                    " to " + parcel.getEndCity().toString() + " deleted");
        } catch (SQLException throwables) {
            daoError("SQLException was caught. Stacktrace is available in console");
            throwables.printStackTrace();
        }
    }

    @Override
    public <T extends Entity> void updateEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "UPDATE parcels SET senderName=?, recipientName=?, startCity=?, endCity=?, weight=? , status=?" +
                    "WHERE parcelID=?";
            Parcel parcel = (Parcel) entity;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, parcel.getSenderName());
            preparedStatement.setString(2, parcel.getRecipientName());
            preparedStatement.setString(3, parcel.getStartCity());
            preparedStatement.setString(4, parcel.getEndCity());
            preparedStatement.setDouble(5, parcel.getWeight());
            preparedStatement.setString(6, parcel.getStatus());
            preparedStatement.setString(7, parcel.getId());
            preparedStatement.executeUpdate();

            logEntityInfo("Parcel " + parcel.getId() + " updated; Parcel info: " + parcel.toString());
        } catch (SQLException throwables) {
            daoError("SQLException was caught. Stacktrace is available in console");
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Parcel> getAllEntities() {
        List<Parcel> parcelList = new ArrayList<>();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            Statement statement = connection.createStatement();
            // returns list of parcels sorted by creation time DESCENDING by default
            ResultSet resultSet = statement.executeQuery("SELECT * FROM parcels ORDER BY timeCreated DESC");
            while (resultSet.next()) {
                Parcel parcel = new Parcel();
                parcel.setId(resultSet.getString("parcelId"));
                parcel.setSenderName(resultSet.getString("senderName"));
                parcel.setRecipientName(resultSet.getString("recipientName"));
                parcel.setStartCity(resultSet.getString("startCity"));
                parcel.setEndCity(resultSet.getString("endCity"));
                parcel.setWeight(resultSet.getDouble("weight"));
                parcel.setStatus(resultSet.getString("status"));
                parcel.setTimeCreated(resultSet.getString("timeCreated"));
                parcel.setTimeUpdated(resultSet.getString("timeUpdated"));
                parcelList.add(parcel);
            }
        } catch (SQLException throwables) {
            daoError("SQLException was caught. Stacktrace is available in console");
            throwables.printStackTrace();
        }
        return parcelList;
    }

    @Override
    public Parcel getEntityById(String id) {
        Parcel parcel = new Parcel();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM parcels WHERE parcelId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                parcel.setId(resultSet.getString("parcelId"));
                parcel.setSenderName(resultSet.getString("senderName"));
                parcel.setRecipientName(resultSet.getString("recipientName"));
                parcel.setStartCity(resultSet.getString("startCity"));
                parcel.setEndCity(resultSet.getString("endCity"));
                parcel.setWeight(resultSet.getDouble("weight"));
                parcel.setStatus(resultSet.getString("status"));
                parcel.setTimeCreated(resultSet.getString("timeCreated"));
                parcel.setTimeUpdated(resultSet.getString("timeUpdated"));
            }
        } catch (SQLException throwables) {
            daoError("SQLException was caught. Stacktrace is available in console");
            throwables.printStackTrace();
        }
        return parcel;
    }

    public List<City> getAllCities() {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM cities";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getString("cityId"));
                city.setCityName(resultSet.getString("cityName"));
                city.setCityAlias(resultSet.getString("cityAlias"));
                cityList.add(city);
            }
        } catch (SQLException throwables) {
            daoError("SQLException was caught. Stacktrace is available in console");
            throwables.printStackTrace();
        }
        return cityList;
    }

    // overloaded method for sorting page by certain column
    public List<Parcel> getAllEntities(String orderBy, String order) {
        List<Parcel> parcelList = new ArrayList<>();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            // Prevent SQL Injection
            String getColumnsQuery = "SELECT column_name FROM information_schema.columns WHERE table_name = 'parcels'";
            Statement statement = connection.createStatement();
            ResultSet resultSetCol = statement.executeQuery(getColumnsQuery);
            List<String> columns = new ArrayList<>();
            while (resultSetCol.next()) {
                columns.add(resultSetCol.getString("COLUMN_NAME"));
            }
            if (columns.contains(orderBy)) {
                String query = "SELECT * FROM parcels ORDER BY " + orderBy + " " + order;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                daoDebug("\"Sql query\" "+query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Parcel parcel = new Parcel();
                    parcel.setId(resultSet.getString("parcelId"));
                    parcel.setSenderName(resultSet.getString("senderName"));
                    parcel.setRecipientName(resultSet.getString("recipientName"));
                    parcel.setStartCity(resultSet.getString("startCity"));
                    parcel.setEndCity(resultSet.getString("endCity"));
                    parcel.setWeight(resultSet.getDouble("weight"));
                    parcel.setStatus(resultSet.getString("status"));
                    parcel.setTimeCreated(resultSet.getString("timeCreated"));
                    parcel.setTimeUpdated(resultSet.getString("timeUpdated"));
                    parcelList.add(parcel);
                }
            } else {
                daoWarn("SQL INJECTION DETECTED");
                return null;
            }
        } catch (SQLException throwables) {
            daoError("SQLException caught");
            throwables.printStackTrace();
        }
        return parcelList;
    }

    @Override
    public void logEntityInfo(String message) {
        logger.info(message);
    }

    public void daoDebug(String message) {
        logger.debug(message);
    }

    public void daoWarn(String message) {
        logger.warn(message);
    }

    public void daoError(String message) {
        logger.error(message);
    }
}
