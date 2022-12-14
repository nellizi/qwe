package com.likelion.stepstone.post;

import com.likelion.stepstone.post.model.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create(@RequestParam String title, @RequestParam String body, @RequestParam UUID userId, Model model){

        PostDto postDto = PostDto.builder()
                .title(title)
                .body(body)
                .userId(userId)
                .build();


        postService.create(postDto);

        model.addAttribute("title", postDto.getTitle());
        model.addAttribute("body", postDto.getBody());

        return "post/create";
    }

}
