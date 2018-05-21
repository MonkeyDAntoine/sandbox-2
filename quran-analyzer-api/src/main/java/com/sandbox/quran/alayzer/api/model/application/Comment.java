package com.sandbox.quran.alayzer.api.model.application;

import com.sandbox.quran.alayzer.api.model.Model;

import java.util.Set;
import java.util.SortedSet;

public interface Comment extends Model {

    Question getQuestion();

    SortedSet<Comment> getReplies();

    Set<Resource> getAttachedReources();

    String getTitle();

    String getDescription();

}
