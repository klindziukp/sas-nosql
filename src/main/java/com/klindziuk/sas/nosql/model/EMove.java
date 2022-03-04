package com.klindziuk.sas.nosql.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EMove {

  @Id
  @GeneratedValue
  private Long id;

  @Property("v") private String v;
  @Property("d") private Integer d;
}
