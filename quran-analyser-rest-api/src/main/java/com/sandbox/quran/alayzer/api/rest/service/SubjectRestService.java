package com.sandbox.quran.alayzer.api.rest.service;

import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.api.rest.service.body.request.SearchSubjectRequestBody;

import java.util.Collection;

public interface SubjectRestService {

    Collection<Subject> getSubjects(int pageNumber, int pageSize);

    Collection<Subject> search(SearchSubjectRequestBody request);

}
