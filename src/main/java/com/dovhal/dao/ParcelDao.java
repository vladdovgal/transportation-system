package com.dovhal.dao;

import com.dovhal.model.Parcel;

import java.util.List;

public interface ParcelDao {
    void createParcel(Parcel parcel);

    void deleteParcel(int id);

    void updateParcel(int ind);

    List<Parcel> getAllParcels();

    Parcel getParcelById();
}
