package com.sandbox.quran.alayzer.neo4j.impl.mapper;

import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.neo4j.impl.model.application.SubjectImpl;

import java.util.Optional;
import java.util.function.Function;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public final class SubjectMapper {
    public static final Function<Subject.Field, Optional<String>> SUBJECT_MAPPER = apiField -> {
        switch (apiField) {
            case TITLE:
                return of(SubjectImpl.TITLE);
            case DESCRIPTION:
                return of(SubjectImpl.DESCRIPTION);
            default:
        }
        return empty();
    };

    public static final Function<Subject, SubjectImpl> SUBJECT_API_TO_IMPL = subject -> {
        SubjectImpl subjectImpl = new SubjectImpl();
        subjectImpl.setId(subject.getId());
        subjectImpl.setTitle(subject.getTitle());
        subjectImpl.setDescription(subject.getDescription());
        subjectImpl.setCreatedDate(subject.getCreatedDate());
        subjectImpl.setLastModificationDate(subject.getLastModificationDate());
        return subjectImpl;
    };

    public static final Function<SubjectImpl, Subject> SUBJECT_IMPL_TO_API = impl -> (Subject) impl;
}