package com.sandbox.quran.alayzer.api.model;

import java.util.Date;

public interface Model {

    interface Field<M extends Model> {
    }

    String getId();

    default Date getCreatedDate() {
        return new Date();
    }

    Date getLastModificationDate();

}
