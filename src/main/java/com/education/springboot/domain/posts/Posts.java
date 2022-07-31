package com.education.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor // Args없는 형태의 생성자 자동 추가
@Entity // Posts를 Entity로 감싼다, 테이블과 링크될 클래스
public class Posts {

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙, auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // Lombok, 해당 클래스의 빌더 패턴 클래스를 생성, 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
