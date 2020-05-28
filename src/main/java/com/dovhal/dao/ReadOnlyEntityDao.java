package com.dovhal.dao;

import com.dovhal.model.Entity;

import java.util.List;

public interface ReadOnlyEntityDao {
    List<? extends Entity> getAllEntities();
}
