package com.sandbox.quran.alayzer.api.service;

import com.sandbox.quran.alayzer.api.model.Model;
import com.sandbox.quran.alayzer.api.model.Sort;

import java.util.Collection;
import java.util.Map;

import static java.util.Collections.emptyMap;

public interface SearchService<M extends Model, F extends Model.Field<M>> {
    int DEFAULT_PAGE_SIZE = 20;

    Collection<M> search(Map<F, String> searchByFields, Integer pageNumber, Integer pageSize, Map<F, Sort> sortByFields);

    default Collection<M> search(Map<F, String> searchByFields) {
        return search(searchByFields, 1, DEFAULT_PAGE_SIZE, emptyMap());
    }

    default Collection<M> getPage(Integer pageNumber, Integer pageSize) {
        return search(emptyMap(), pageNumber, pageSize, emptyMap());
    }

}
