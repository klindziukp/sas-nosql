package com.klindziuk.sas.nosql.mapper;

import com.klindziuk.sas.nosql.model.Move;
import com.klindziuk.sas.nosql.model.dto.MoveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MoveMapper {

  MoveMapper MAPPER = Mappers.getMapper(MoveMapper.class);

  @Mapping(target = "c", source = "moveDto.c")
  @Mapping(target = "n", source = "moveDto.n")
  @Mapping(target = "m", source = "moveDto.m")
  @Mapping(target = "e", source = "moveDto.e")
  @Mapping(target = "moves", ignore = true)
  @Mapping(target = "id", ignore = true)
  Move toMove(final MoveDto moveDto);
}
