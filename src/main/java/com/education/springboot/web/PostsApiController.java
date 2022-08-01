package com.education.springboot.web;

import com.education.springboot.service.posts.PostsService;
import com.education.springboot.web.dto.PostsResponseRequestDto;
import com.education.springboot.web.dto.PostsSaveRequestDto;
import com.education.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // @AutoWired 대체로, 생성자를 통해서 Bean을 주입받음(Lombok)
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseRequestDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
