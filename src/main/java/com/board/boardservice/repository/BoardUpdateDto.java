package com.board.boardservice.repository;


import lombok.Data;

@Data
public class BoardUpdateDto {

    private String title;
    private String content;
    private String writer;

    public BoardUpdateDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
