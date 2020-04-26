package com.dovhal.dao;

import com.dovhal.model.City;
import com.dovhal.model.Parcel;
import com.dovhal.util.DBConnectionUtility;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * ParcelDaoImpl.java is a class, which implements ParcelDao
 * It is used for implementation of CRUD and other methods
 *
 * @author vladd
 */
public class ParcelDaoImpl implements ParcelDao {

    public void createParcel(Parcel parcel) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "INSERT INTO parcels (senderName,recipientName,startCity,endCity,weight)" +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, parcel.getSenderName());
            preparedStatement.setString(2, parcel.getRecipientName());
            preparedStatement.setString(3, parcel.getStartCity());
            preparedStatement.setString(4, parcel.getEndCity());
            preparedStatement.setDouble(5, parcel.getWeight());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteParcel(int id) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "DELETE FROM parcels WHERE parcelID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateParcel(Parcel parcel) {
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "UPDATE parcels SET senderName=?, recipientName=?, startCity=?, endCity=?,weight=? " +
                    "WHERE parcelID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, parcel.getSenderName());
            preparedStatement.setString(2, parcel.getRecipientName());
            preparedStatement.setString(3, parcel.getStartCity());
            preparedStatement.setString(4, parcel.getEndCity());
            preparedStatement.setDouble(5, parcel.getWeight());
            preparedStatement.setInt(6, parcel.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Parcel> getAllParcels() {
        List<Parcel> parcelList = new LinkedList<>();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM parcels");
            while (resultSet.next()) {
                Parcel parcel = new Parcel();
                parcel.setId(resultSet.getInt("parcelID"));
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

    public Parcel getParcelById(int id) {
        Parcel parcel = new Parcel();
        try (Connection connection = DBConnectionUtility.getDBConnection()) {
            String query = "SELECT * FROM parcels WHERE parcelID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                parcel.setId(resultSet.getInt("parcelID"));
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
}
