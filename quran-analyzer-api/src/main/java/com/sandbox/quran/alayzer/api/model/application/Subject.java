package com.sandbox.quran.alayzer.api.model.application;

import com.sandbox.quran.alayzer.api.model.Model;

public interface Subject extends Model {

    enum Field implements Model.Field<Subject> {
        TITLE, DESCRIPTION
    }

    String getTitle();

    String getDescription();

}
