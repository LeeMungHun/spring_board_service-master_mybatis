package com.board.boardservice.repository.mybatis;

import com.board.boardservice.domain.entity.Board;
import com.board.boardservice.repository.BoardDto;
import com.board.boardservice.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisRepository implements BoardRepository {

    private final BoardMapper boardMapper;

    @Override
    public Board save(Board board) {
        boardMapper.save(board);
        return board;
    }

    @Override
    public void update(Long id, BoardDto boardDto) {
        boardMapper.update(id,boardDto);
    }

    @Override
    public List<Board> findByTitle(String title) {
        return boardMapper.findByTitle(title);
    }

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardMapper.findById(id);
    }

    @Override
    public void deleteById(Long id) {boardMapper.deleteById(id);}

    //페이징 인덱스
//    @Override
//    public int count(){
//        return boardMapper.count();
//    }
}
