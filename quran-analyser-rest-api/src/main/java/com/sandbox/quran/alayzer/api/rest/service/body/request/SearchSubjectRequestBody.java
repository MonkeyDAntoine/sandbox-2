package com.sandbox.quran.alayzer.api.rest.service.body.request;

import com.sandbox.quran.alayzer.api.model.Sort;
import com.sandbox.quran.alayzer.api.model.application.Subject;

import java.util.Map;

/**
 * Created by MSI on 21/05/2018.
 */
public interface SearchSubjectRequestBody {
    Map<Subject.Field, String> getSearchByFields();

    Integer getPageNumber();

    Integer getPageSize();

    Map<Subject.Field, Sort> getSortByFields();
}
