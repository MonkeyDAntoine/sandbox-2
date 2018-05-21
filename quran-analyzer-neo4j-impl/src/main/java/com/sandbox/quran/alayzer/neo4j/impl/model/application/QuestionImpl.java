package com.sandbox.quran.alayzer.neo4j.impl.model.application;

import com.sandbox.quran.alayzer.api.model.application.Question;
import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.neo4j.impl.model.Node;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by MSI on 21/05/2018.
 */
public class QuestionImpl extends Node implements Question {

    String title;

    String description;

    @Relationship(type = "BELONGS_TO")
    Subject subject;

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

    @Override
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
