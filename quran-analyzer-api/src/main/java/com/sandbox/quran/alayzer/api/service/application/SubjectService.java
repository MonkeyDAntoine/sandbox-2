package com.sandbox.quran.alayzer.api.service.application;

import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.api.service.ModelService;
import com.sandbox.quran.alayzer.api.service.SearchService;

public interface SubjectService extends ModelService<Subject>, SearchService<Subject, Subject.Field> {
}
