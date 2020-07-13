package com.dovhal.dao;

import com.dovhal.model.Entity;


import java.util.List;

public interface EntityDao {
    /**
     * <h3> Method designed for creation of new entity </h3>
     *
     * @param entity entity with data to insert into database
     */
    <T extends Entity> void createEntity(T entity);

    /**
     * <h3> Method designed for deletion of entity </h3>
     *
     * @param id entity identifier
     */
    void deleteEntity(String id);

    /**
     * <h3> Method designed for updating entity </h3>
     *
     * @param entity entity to update
     */
    <T extends Entity> void updateEntity(T entity);

    /**
     * <h3> Method designed for getting list of entities </h3>
     *
     * @return list of entities
     */
    List<? extends Entity> getAllEntities();

    /**
     * <h3> Method designed for getting entity by id </h3>
     *
     * @param id entity identifier
     * @return entity
     */
    <T extends Entity> T getEntityById(String id);

    /**
     * <h3> Method designed for logging </h3>
     *
     * @param message info about event / exception
     */
    void logEntityInfo(String message);
}
