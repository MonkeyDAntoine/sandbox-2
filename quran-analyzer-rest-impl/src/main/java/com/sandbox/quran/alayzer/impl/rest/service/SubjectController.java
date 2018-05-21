package com.sandbox.quran.alayzer.impl.rest.service;

import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.api.rest.service.SubjectRestService;
import com.sandbox.quran.alayzer.api.rest.service.body.request.SearchSubjectRequestBody;
import com.sandbox.quran.alayzer.api.service.application.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/subject")
public class SubjectController implements SubjectRestService {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    @GetMapping("/")
    public Collection<Subject> getSubjects(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        return subjectService.getPage(pageNumber, pageSize);
    }

    @Override
    @PostMapping("/search")
    public Collection<Subject> search(@RequestBody SearchSubjectRequestBody request) {
        return subjectService.search(request.getSearchByFields(), request.getPageNumber(), request.getPageSize(), request.getSortByFields());
    }
}
