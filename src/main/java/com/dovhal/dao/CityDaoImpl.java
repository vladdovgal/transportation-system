package com.dovhal.dao;

import com.dovhal.model.City;
import com.dovhal.model.Entity;
import com.dovhal.util.DBConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements EntityDao {
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

    @Override
    public void deleteEntity(int id) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "DELETE FROM cities WHERE cityId = ?";
            City city = getEntityById(id);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logEntityInfo("City named " + city.getCityName() + " was removed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while deleting entity");
        }
    }

    @Override
    public <T extends Entity> void updateEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "UPDATE cities SET cityName=?, cityAlias=?" +
                    "WHERE cityId=?";

            City city = (City) entity;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setString(2, city.getCityAlias());
            preparedStatement.setInt(3, city.getId());
            preparedStatement.executeUpdate();

            logEntityInfo("City with id = " + city.getId() + " was updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while updating entity");
        }
    }

    @Override
    public List<City> getAllEntities() {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM cities";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("cityId"));
                city.setCityName(resultSet.getString("cityName"));
                city.setCityAlias(resultSet.getString("cityAlias"));
                cityList.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Caught SQLException; Something went wrong while displaying all entities");
        }
        return cityList;
    }

    @Override
    public City getEntityById(int id) {
        City city = new City();
        try(Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM cities WHERE cityId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                city.setId(resultSet.getInt("cityId"));
                city.setCityName(resultSet.getString("cityName"));
                city.setCityAlias(resultSet.getString("cityAlias"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return city;
    }

    @Override
    public void logEntityInfo(String message) {
        logger.info(message);
    }
}
