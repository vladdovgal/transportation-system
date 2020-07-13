package com.dovhal.dao;

import com.dovhal.model.City;
import com.dovhal.model.Entity;
import com.dovhal.util.DBConnectionUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CityDaoImpl.java is a class, which implements EntityDAO
 * It is used for implementation of CRUD and other methods
 *
 * @author vladd
 * @version 1.0
 */
public class CityDaoImpl implements EntityDao {
    Logger logger = LogManager.getLogger(CityDaoImpl.class);

    /**
     * <h3> Overridden method for creation of new city </h3>
     *
     * @param entity city data to insert into database
     */
    @Override
    public <T extends Entity> void createEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "INSERT INTO cities (cityName, cityAlias) VALUES (?,?)";

            City city = (City) entity;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setString(2, city.getCityName().substring(0, 2).toUpperCase());
            preparedStatement.executeUpdate();

            logEntityInfo(city.getCityName() + "City added");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while creating entity");
        }
    }

    /**
     * <h3> Overridden method for deletion of existing city </h3>
     *
     * @param id city identifier
     */
    @Override
    public void deleteEntity(String id) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "DELETE FROM cities WHERE cityId = ?";
            City city = getEntityById(id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            logEntityInfo("City named " + city.getCityName() + " was removed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while deleting entity");
        }
    }
    /**
     * <h3> Overridden method for updating of existing city </h3>
     *
     * @param entity city object
     */
    @Override
    public <T extends Entity> void updateEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "UPDATE cities SET cityName=?, cityAlias=?" +
                    "WHERE cityId=?";

            City city = (City) entity;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setString(2, city.getCityAlias());
            preparedStatement.setString(3, city.getId());
            preparedStatement.executeUpdate();

            logEntityInfo("City with id = " + city.getId() + " was updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while updating entity");
        }
    }

    /**
     * <h3> Overridden method for getting list of cities </h3>
     *
     * @return list of cities
     */
    @Override
    public List<City> getAllEntities() {
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
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while displaying all cities");
        }
        return cityList;
    }

    /**
     * <h3> Overridden method for getting city by it's id. </h3>
     *
     * @return city object
     */
    @Override
    public City getEntityById(String id) {
        City city = new City();
        try(Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM cities WHERE cityId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                city.setId(resultSet.getString("cityId"));
                city.setCityName(resultSet.getString("cityName"));
                city.setCityAlias(resultSet.getString("cityAlias"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return city;
    }

    /**
     * <h3> Overridden method for logging </h3>
     *
     * @param message  message for user about event or exception
     */
    @Override
    public void logEntityInfo(String message) {
        logger.info(message);
    }
}
