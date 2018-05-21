package com.sandbox.quran.alayzer.api.model.quran;

import com.sandbox.quran.alayzer.api.model.Model;

import java.util.Locale;
import java.util.Map;

public interface Verse extends Model {
    default String getId() {
        return (getSurah() != null ? getSurah().getNumber() : null) + ":" + getNumber();
    }

    Surah getSurah();

    Integer getNumber();

    String getText();

    Map<Locale, Verse> getTranslations();
}
