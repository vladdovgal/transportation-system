package com.dovhal.dao;

import com.dovhal.model.City;
import com.dovhal.model.Entity;
import com.dovhal.util.DBConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CityDaoImpl implements EntityDao{
    @Override
    public <T extends Entity> void createEntity(T entity) {
        try(Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "INSERT INTO cities (cityName, cityAlias) VALUES (?,?)";

            City city = (City)entity;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setString(2, city.getCityName().substring(0,2).toUpperCase());
            preparedStatement.executeUpdate();

            logger.info(city.getCityName() + "City added. Alias: " + city.getCityAlias());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("SQLException was caught : See stacktrace above");
        }
    }

    @Override
    public void deleteEntity(int id) {

    }

    @Override
    public <T extends Entity> void updateEntity(T entity) {

    }

    @Override
    public List<? extends Entity> getAllEntities() {
        return null;
    }

    @Override
    public <T extends Entity> T getEntityById(int id) {
        return null;
    }
}
