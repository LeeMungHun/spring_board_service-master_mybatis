package com.board.boardservice.service;

import com.board.boardservice.domain.entity.Board;
import com.board.boardservice.repository.BoardRepository;
import com.board.boardservice.repository.BoardDto;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//수동빈 등록
//@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board save(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity());
    }

    @Transactional
    public void deleteById(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Transactional
    public void update(Long boardId, BoardDto boardDto) {
        Optional<Board> byId = boardRepository.findById(boardId);
        Board board = byId.get();
        board.setContent(boardDto.getContent());
        board.setTitle(boardDto.getTitle());
        board.setWriter(boardDto.getWriter());
        boardRepository.update(board.getId(),boardDto);
    }

    @Transactional
    public BoardDto findBoard(Long boardId) {
        Optional<Board> byId = boardRepository.findById(boardId);
        Board board = byId.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();

        return boardDto;
    }

    @Transactional
    public List<BoardDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .content(board.getContent())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }


    @Transactional
    public List<BoardDto> findByTitle(String searchTitle) {
        List<Board> boards = boardRepository.findByTitle(searchTitle);
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .content(board.getContent())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

}
