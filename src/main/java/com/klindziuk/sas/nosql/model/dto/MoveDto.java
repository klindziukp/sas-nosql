package com.klindziuk.sas.nosql.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.klindziuk.sas.nosql.model.EMove;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoveDto {

  private Long targetNodeId;
  private String c;
  private String t;
  private String m;
  private Integer n;
  private EMove e;

}
