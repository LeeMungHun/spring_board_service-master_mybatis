package com.board.boardservice.config;

import com.board.boardservice.repository.BoardRepository;
import com.board.boardservice.repository.mybatis.BoardMapper;
import com.board.boardservice.repository.mybatis.MyBatisRepository;

import com.board.boardservice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final BoardMapper boardMapper;

    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new MyBatisRepository(boardMapper);
    }

}
