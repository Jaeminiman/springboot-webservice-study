package com.education.springboot.web.dto;

import com.education.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    // PostsResponseDto 는 Entity 의 필드 중 일부만 사용하므로, 생성자로 Entity 를 받아서 넣는다.
    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
