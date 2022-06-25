package com.board.boardservice.repository;

import com.board.boardservice.domain.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);

    void update(Long id, BoardDto boardDto);

    List<Board> findByTitle(String title);

    List<Board> findAll();

    Optional<Board> findById(Long id);

    void deleteById(Long boardId);

//    int count();
}
