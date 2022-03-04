package com.klindziuk.sas.nosql.repository;

import com.klindziuk.sas.nosql.model.Move;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface EMoveRepository extends Neo4jRepository<Move, Long> {


}
