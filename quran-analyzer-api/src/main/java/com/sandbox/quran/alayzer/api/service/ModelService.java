package com.sandbox.quran.alayzer.api.service;

import com.sandbox.quran.alayzer.api.model.Model;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public interface ModelService<M extends Model> {
    M save(M model);

    Optional<M> findById(String id);

    M update(M model);

    boolean delete(M model);

    default boolean deleteAll(Collection<M> models) {
        if (models == null || models.isEmpty()) {
         return true;
        }
        boolean result = true;
        for (M model : models) {
            result = result && delete(model);
        }
        return result;
    }
}
