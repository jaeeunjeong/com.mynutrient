package com.mynutrient.community.controller;

import com.mynutrient.community.domain.Posts;
import com.mynutrient.community.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommunityController {

    private final PostsService postsService;

    @Autowired
    public CommunityController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("community/save")
    public Long savaPost(@RequestBody Posts posts) {
        return postsService.save(posts);
    }

    @PostMapping("community/update")
    public Long updatePost(@RequestBody Posts posts) {
        return postsService.update(posts);
    }

    @GetMapping("community/delete/{postId}")
    public void deletePost(@PathVariable int postId) {//실제로 지우지 않고 update를 이용해서 제거
        postsService.deletePost(postId);
    }

    @GetMapping("communuty/read/{postId}")
    public Posts readPost(@PathVariable int postId){
        return postsService.readPost(postId);
    }

    @GetMapping("communuty/home")
    public List<Posts> selectPostsList(@RequestParam (required = false) int page){
        return postsService.selectPostsList();
    }

    /**
     * condition : 1 : 제목만 2 : 내용만  3 : 제목 + 내용
     * */
    @GetMapping("/posts/search/{word}/{condition}")
    public  List<Posts> searchPostBywordWithCondition(Model model,
                                               @PathVariable String word,
                                              @PathVariable String searchByConditon){

        return postsService.searchPostBywordWithCondition(model, word, searchByConditon);
    }

}
