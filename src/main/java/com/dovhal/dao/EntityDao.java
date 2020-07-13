package com.dovhal.dao;

import com.dovhal.model.Entity;


import java.util.List;

public interface EntityDao {
    <T extends Entity> void createEntity(T entity);

    void deleteEntity(String id);

    <T extends Entity> void updateEntity(T entity);

    List<? extends Entity> getAllEntities();

    <T extends Entity> T getEntityById(String id);

    void logEntityInfo(String message);
}
