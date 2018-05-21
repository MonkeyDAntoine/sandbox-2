package com.sandbox.quran.alayzer.api.model.application;

import com.sandbox.quran.alayzer.api.model.Model;

public interface Question extends Model {

    Subject getSubject();

    String getTitle();

    String getDescription();

}
