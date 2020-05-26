package com.dovhal.dao;


import com.dovhal.model.Entity;
import com.dovhal.model.Parcel;
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
 */
public class ParcelDaoImpl implements EntityDao {

    public <T extends Entity> void createEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "INSERT INTO parcels (parcelId,senderName,recipientName,startCity,endCity,weight)" +
                    "VALUES (?,?,?,?,?,?)";
            Random random = new Random();
            int parcelGeneratedId = Integer.parseInt(String.format("%06d", random.nextInt(999999)));
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, parcelGeneratedId);
            Parcel parcel = (Parcel) entity;
            preparedStatement.setString(2, parcel.getSenderName());
            preparedStatement.setString(3, parcel.getRecipientName());
            preparedStatement.setString(4, parcel.getStartCity());
            preparedStatement.setString(5, parcel.getEndCity());
            preparedStatement.setDouble(6, parcel.getWeight());
            preparedStatement.executeUpdate();

            logParcelInfo("Parcel №" + parcelGeneratedId + " from " + parcel.getStartCity().toString() +
                    " to " + parcel.getEndCity().toString() + " created");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("SQLException was caught : See stacktrace above");
        }
    }


    public void deleteEntity(int id) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            Parcel parcel = getEntityById(id);
            String query = "DELETE FROM parcels WHERE parcelID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            logParcelInfo("Parcel №" + id + " from " + parcel.getStartCity().toString() +
                    " to " + parcel.getEndCity().toString() + " deleted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public <T extends Entity> void updateEntity(T entity) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "UPDATE parcels SET senderName=?, recipientName=?, startCity=?, endCity=?, weight=? " +
                    "WHERE parcelID=?";
            Parcel parcel = (Parcel) entity;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, parcel.getSenderName());
            preparedStatement.setString(2, parcel.getRecipientName());
            preparedStatement.setString(3, parcel.getStartCity());
            preparedStatement.setString(4, parcel.getEndCity());
            preparedStatement.setDouble(5, parcel.getWeight());
            preparedStatement.setInt(6, parcel.getId());
            preparedStatement.executeUpdate();

            logParcelInfo("Parcel №" + parcel.getId() + " updated; Parcel info: " + parcel.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Parcel> getAllEntities() {
        List<Parcel> parcelList = new ArrayList<>();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM parcels");
            while (resultSet.next()) {
                Parcel parcel = new Parcel();
                parcel.setId(resultSet.getInt("parcelId"));
                parcel.setSenderName(resultSet.getString("senderName"));
                parcel.setRecipientName(resultSet.getString("recipientName"));
                parcel.setStartCity(resultSet.getString("startCity"));
                parcel.setEndCity(resultSet.getString("endCity"));
                parcel.setWeight(resultSet.getDouble("weight"));
                parcelList.add(parcel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return parcelList;
    }

    public Parcel getEntityById(int id) {
        Parcel parcel = new Parcel();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM parcels WHERE parcelId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                parcel.setId(resultSet.getInt("parcelId"));
                parcel.setSenderName(resultSet.getString("senderName"));
                parcel.setRecipientName(resultSet.getString("recipientName"));
                parcel.setStartCity(resultSet.getString("startCity"));
                parcel.setEndCity(resultSet.getString("endCity"));
                parcel.setWeight(resultSet.getDouble("weight"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return parcel;
    }

    public void logParcelInfo(String message) {
        logger.info(message);
    }
}
