package com.dovhal.dao;

import com.dovhal.model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface EntityDao {
    Logger logger = LogManager.getLogger(ParcelDaoImpl.class);

    <T extends Entity> void createEntity(T entity);

    void deleteEntity(String id);

    <T extends Entity> void updateEntity(T entity);

    List<? extends Entity> getAllEntities();

    <T extends Entity> T getEntityById(String id);

    void logEntityInfo(String message);
}
