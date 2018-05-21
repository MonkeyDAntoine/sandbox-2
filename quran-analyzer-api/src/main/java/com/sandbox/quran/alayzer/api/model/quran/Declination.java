package com.sandbox.quran.alayzer.api.model.quran;

import com.sandbox.quran.alayzer.api.model.Model;

public interface Declination extends Model {
    
    default String getId() {
        return getName();
    }

    String getName();

    Word getWord();

    Word getDeclinedWord();

}
