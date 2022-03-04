package com.klindziuk.sas.nosql.controller;

import com.klindziuk.sas.nosql.model.Move;
import com.klindziuk.sas.nosql.model.dto.MoveDto;
import com.klindziuk.sas.nosql.repository.EMoveRepository;
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
  private final EMoveRepository emoveRepository;

  public MoveController(MoveRepository moveRepository, EMoveRepository emoveRepository) {
    this.moveRepository = moveRepository;
    this.emoveRepository = emoveRepository;
  }

  @GetMapping
  public List<Move> findAll() {
    return moveRepository.findAll();
  }

  @GetMapping("/clear")
  public List<Move> findAllClear() {
    return moveRepository.getAllMovesDistinct();
  }

  @GetMapping("/d")
  public List<Move> findAllClear1() {
    return moveRepository.findDistinctOrderById();
  }

  @PostMapping("/save")
  public Move saveMove( @RequestBody MoveDto moveDto){
    Long targetNodeId = moveDto.getTargetNodeId();
    Move move = new Move();
    move.setC(moveDto.getC());
    move.setE(moveDto.getE());
    move.setM(moveDto.getM());
    move.setE(moveDto.getE());
    if(Objects.nonNull(targetNodeId)) {
      Optional<Move> byId = moveRepository.findById(targetNodeId);
      if(byId.isPresent()){
        Move moveToSave = byId.get();
        moveToSave.getMoves().add(move);
        moveRepository.save(moveToSave);
      }
    }
    return move;
  }

  @GetMapping("/{m}")
  public List<Move> getMoveByM(@PathVariable String m) {
    return moveRepository.getAllMovesByM(m);
  }
}
