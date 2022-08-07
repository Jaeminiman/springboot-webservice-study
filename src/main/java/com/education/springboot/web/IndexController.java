package com.education.springboot.web;

import com.education.springboot.config.auth.LoginUser;
import com.education.springboot.config.auth.dto.SessionUser;
import com.education.springboot.service.posts.PostsService;
import com.education.springboot.web.dto.PostsListResponseDto;
import com.education.springboot.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user){ // (1)
        model.addAttribute("posts",postsService.findAllDesc()); // {{#Posts}}를 List로 대체함

        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index"; // src/main/resources/templates/index.mustache 로 전환되어 view Resolver 처리
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
