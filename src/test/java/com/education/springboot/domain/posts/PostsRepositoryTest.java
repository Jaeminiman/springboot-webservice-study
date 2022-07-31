package com.education.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 데이터베이스 자동으로 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;// JPA는 생성자 없이 이렇게 할 수 있다.

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //.save() -> 테이블에 insert/update 쿼리를 수행 id가 있으면 update, 없으면 insert 수행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("wpals113@snu.ac.kr")
                .build());

        //when
        List<Posts> result = postsRepository.findAll();

        //then
        Posts posts = result.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
