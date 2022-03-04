package com.klindziuk.sas.nosql.model;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Move")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Move {

  @Id
  @GeneratedValue
  private Long id;

  @Property("c")  private String c;
  @Property("t")  private String t;
  @Property("m")  private String m;
  @Property("n")  private Integer n;
  @Relationship(type = "DIMENSION")
  private EMove e;
  @Relationship(type = "MOVE")
  @JsonProperty("s")
  private List<Move> moves;
}
