package com.klindziuk.sas.nosql.repository;

import com.klindziuk.sas.nosql.model.Move;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface MoveRepository extends Neo4jRepository<Move, Long> {

  @Query("MATCH (am:Move)<-[ai:MOVE]-(m:Move)-[d:DIMENSION]->(e:EMove)"
      + "OPTIONAL MATCH(m1:Move)-[d1:DIMENSION]->(e1:EMove)"
      + "return DISTINCT collect(am),collect(ai),collect(d),collect(e),m1,collect(d1),collect(e1)")
  List<Move> getAllMovesDistinct();

  List<Move> findMoveById(String id);

  List<Move> getAllMovesByM(String m);
}
