package com.mynutrient.community.controller;

import com.mynutrient.community.domain.Posts;
import com.mynutrient.community.service.PostsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommunityController {

    private final PostsService postsService;

    public CommunityController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("community/save")
    public Long savaPost(@RequestBody Posts posts) {
        return postsService.save(posts);
    }

    @GetMapping("community/update")
    public Long updatePost(@RequestParam Posts posts) {
        return postsService.update(posts);
    }

    @GetMapping("community/delete")
    public void deletePost(@RequestParam int postId) {//실제로 지우지 않고 update를 이용해서 제거
        postsService.deletePost(postId);
    }

    /**
     * condition : 1 : 제목만 2 : 내용만  3 : 제목 + 내용
     * */
    /*
    @GetMapping("/posts/search/{word}/{condition}")
    public  List<Posts> searchPostBywordWithCondition(Model model,
                                               @RequestParam String word,
                                              @RequestParam String searchByConditon){

        return postsService.searchPostBywordWithCondition(model, word, searchByConditon);
    }
    */

    @GetMapping("communuty/read")
    public Posts readPost(@RequestParam int postId){
        return postsService.readPost(postId);
    }

    @GetMapping("communuty/index")
    public List<Posts> selectPostsList(){
        return null;
    }
}
