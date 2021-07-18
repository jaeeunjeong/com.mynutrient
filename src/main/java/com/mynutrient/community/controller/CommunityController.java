package com.mynutrient.community.controller;

import com.mynutrient.community.domain.Posts;
import com.mynutrient.community.service.PostsService;
import com.mynutrient.community.web.dto.PostsSaveRequestDto;
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
    public Long savaPost(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("community/update")
    public boolean updatePost(@RequestParam int postId) {
        return false;
    }

    @GetMapping("community/delete")
    public void deletePost(@RequestParam int postId) {//실제로 지우지 않고 update를 이용해서 제거

    }

    /**
     * condition : 1 : 제목만 2 : 내용만  3 : 제목 + 내용
     * */
    @GetMapping("communuty/search")
    public void searchPostBywordWithCondition(@RequestParam int postId,
                                              @RequestParam String word,
                                              @RequestParam int searchByConditon){
        
    }

    @GetMapping("communuty/read")
    public void readPost(@RequestParam int postId){

    }

    @GetMapping("communuty/index")
    public List<Posts> selectPostsList(){
        return null;
    }
}
