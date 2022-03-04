package com.klindziuk.sas.nosql.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RelationshipProperties
public class Moves {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private List<Move> moves;
}
