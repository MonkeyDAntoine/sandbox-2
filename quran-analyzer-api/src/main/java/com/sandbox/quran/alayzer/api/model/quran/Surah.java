package com.sandbox.quran.alayzer.api.model.quran;

import com.sandbox.quran.alayzer.api.model.Model;

import java.util.Objects;

public interface Surah extends Model {
    default String getId() {
        return Objects.toString(getNumber(), null);
    }

    Integer getNumber();

    String getName();
}
