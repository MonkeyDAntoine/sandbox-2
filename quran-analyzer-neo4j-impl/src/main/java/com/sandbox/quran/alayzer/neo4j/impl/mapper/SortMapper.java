package com.sandbox.quran.alayzer.neo4j.impl.mapper;

import com.sandbox.quran.alayzer.api.model.Sort;
import org.neo4j.ogm.cypher.query.SortOrder;

public class SortMapper {
    public static final SortOrder.Direction getDirection(Sort sortApi) {
        switch (sortApi) {
            case ASC:
                return SortOrder.Direction.ASC;
            case DESC:
                return SortOrder.Direction.DESC;
        }
        return SortOrder.Direction.ASC;
    }
}
