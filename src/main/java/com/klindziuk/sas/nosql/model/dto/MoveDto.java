package com.klindziuk.sas.nosql.model.dto;

import com.klindziuk.sas.nosql.model.EMove;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
