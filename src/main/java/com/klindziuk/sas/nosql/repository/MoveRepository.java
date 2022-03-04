package com.klindziuk.sas.nosql.repository;

import com.klindziuk.sas.nosql.model.Move;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface MoveRepository extends Neo4jRepository<Move, Long> {

   // collect(am)
   // collect(e)
   // collect(e1)
   @Query("MATCH (am:Move)<-[ai:MOVE]-(m:Move)-[d:DIMENSION]->(e:EMove)"
       + " OPTIONAL MATCH(m1:Move)-[d1:DIMENSION]->(e1:EMove) return DISTINCT m,collect(am)")
   List<Move> getAllMovesDistinct();

   List<Move> findDistinctOrderById();

  List<Move> getAllMovesByM(String m);
}
