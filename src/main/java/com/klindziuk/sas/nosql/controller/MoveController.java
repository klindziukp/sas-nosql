package com.klindziuk.sas.nosql.controller;

import com.klindziuk.sas.nosql.mapper.MoveMapper;
import com.klindziuk.sas.nosql.model.Move;
import com.klindziuk.sas.nosql.model.dto.MoveDto;
import com.klindziuk.sas.nosql.repository.MoveRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moves")
public class MoveController {

  private final MoveRepository moveRepository;

  public MoveController(MoveRepository moveRepository) {
    this.moveRepository = moveRepository;
  }

  @GetMapping
  public List<Move> findAll() {
    return moveRepository.findAll();
  }

  @GetMapping("/{id}")
  public List<Move> getMoveById(@PathVariable String id) {
    return moveRepository.findMoveById(id);
  }

  @GetMapping("/{m}")
  public List<Move> getMoveByM(@PathVariable String m) {
    return moveRepository.getAllMovesByM(m);
  }

  @PostMapping("/save")
  public Move saveMove(@RequestBody MoveDto moveDto) {
    final Long targetNodeId = moveDto.getTargetNodeId();
    final Move move = MoveMapper.MAPPER.toMove(moveDto);
    if (Objects.nonNull(targetNodeId)) {
      Optional<Move> byId = moveRepository.findById(targetNodeId);
      if (byId.isPresent()) {
        Move moveToSave = byId.get();
        moveToSave.getMoves().add(move);
        moveRepository.save(moveToSave);
      }
    }
    moveRepository.save(move);
    return move;
  }
}
