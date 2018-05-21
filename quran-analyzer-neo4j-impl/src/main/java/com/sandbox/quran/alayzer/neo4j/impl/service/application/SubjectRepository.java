package com.sandbox.quran.alayzer.neo4j.impl.service.application;

import com.sandbox.quran.alayzer.api.model.Sort;
import com.sandbox.quran.alayzer.api.model.application.Subject;
import com.sandbox.quran.alayzer.api.service.application.SubjectService;
import com.sandbox.quran.alayzer.neo4j.impl.model.application.SubjectImpl;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.cypher.query.Pagination;
import org.neo4j.ogm.cypher.query.SortOrder;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static com.sandbox.quran.alayzer.neo4j.impl.mapper.SortMapper.getDirection;
import static com.sandbox.quran.alayzer.neo4j.impl.mapper.SubjectMapper.*;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.MapUtils.emptyIfNull;
import static org.neo4j.ogm.cypher.ComparisonOperator.LIKE;

@Repository
@Transactional(readOnly = true)
public class SubjectRepository implements SubjectService {

    private Session session;

    @Autowired
    public SubjectRepository(Session session) {
        this.session = session;
    }

    @Override
    @Transactional
    public Subject save(Subject model) {
        SubjectImpl impl = SUBJECT_API_TO_IMPL.apply(model);
        session.save(impl);
        return impl;
    }

    @Override
    public Optional<Subject> findById(String id) {
        return ofNullable(session.load(SubjectImpl.class, id)).map(SUBJECT_IMPL_TO_API);
    }

    @Override
    @Transactional
    public Subject update(Subject model) {
        //if id is present, node will be updated
        return save(model);
    }

    @Override
    @Transactional
    public boolean delete(Subject model) {
        session.delete(SUBJECT_API_TO_IMPL.apply(model));
        return !findById(model.getId()).isPresent();
    }

    @Override
    public Collection<Subject> search(Map<Subject.Field, String> searchByFields, Integer pageNumber, Integer pageSize, Map<Subject.Field, Sort> sortByFields) {
        Filters filters = new Filters();
        for (Map.Entry<Subject.Field, String> search : emptyIfNull(searchByFields).entrySet()) {
            filters.add(new Filter(SUBJECT_MAPPER.apply(search.getKey()).get(), LIKE, search.getValue()));
        }

        SortOrder sortOrder = new SortOrder();
        for (Map.Entry<Subject.Field, Sort> sort : emptyIfNull(sortByFields).entrySet()) {
            sortOrder.add(getDirection(sort.getValue()), SUBJECT_MAPPER.apply(sort.getKey()).get());
        }

        Collection<SubjectImpl> result = session.loadAll(SubjectImpl.class, filters, sortOrder, new Pagination(pageNumber, pageSize), 1);
        return result.stream().map(SUBJECT_IMPL_TO_API).collect(toList());
    }
}
