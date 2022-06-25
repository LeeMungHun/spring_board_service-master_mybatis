package com.board.boardservice.repository.mybatis;

import com.board.boardservice.domain.entity.Board;
import com.board.boardservice.repository.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    void save(Board board);

    void update(@Param("id") Long id, @Param("updateParam") BoardDto boardDto);

    void deleteById(@Param("id") Long id);

    List<Board> findAll();

    List<Board> findByTitle(String title);

    Optional<Board> findById(Long id);

//    int count();
}
