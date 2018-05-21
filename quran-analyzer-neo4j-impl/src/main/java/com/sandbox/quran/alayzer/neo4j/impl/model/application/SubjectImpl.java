package com.sandbox.quran.alayzer.neo4j.impl.model.application;

import com.sandbox.quran.alayzer.api.model.application.Question;
import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.neo4j.impl.model.Node;
import org.neo4j.ogm.annotation.Property;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl extends Node implements Subject {

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";

    @Property(name = TITLE)
    String title;

    @Property(name = DESCRIPTION)
    String description;

    private List<Question> questions = new ArrayList<>();

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
