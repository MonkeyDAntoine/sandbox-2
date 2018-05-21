package com.sandbox.quran.alayzer.api.model.quran;

import com.sandbox.quran.alayzer.api.model.Model;

import java.util.Locale;
import java.util.SortedSet;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsFirst;
import static java.util.Objects.compare;

public interface Word extends Model, Comparable {

    default String getId() {
        return getLocale() + ":" + getText();
    }

    SortedSet<Verse> getVerses();

    String getDefinition();

    String getText();

    Locale getLocale();

}
