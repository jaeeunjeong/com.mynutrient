package com.mynutrient.community.service;

import com.mynutrient.community.domain.Posts;
import com.mynutrient.community.repository.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Transactional
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Long save(Posts post){
        return postsRepository.savePost(post).getPostSeq();
    }

    public Long update(Posts post){
        return postsRepository.updatePost(post);
    }

    public Posts readPost(int postSeqId){
        return postsRepository.readPost(postSeqId);
    }

    public Long deletePost(int postSeq){
        Long id = postsRepository.deletePost(postSeq);
        return id;
    }
    public List<Posts> selectPostsList(){
        return postsRepository.selectPostsList();
    }

    /*
    public List<Posts> searchPostBywordWithCondition(Model model,
                                                     @RequestParam ("searchWord") String word,
                                                     @RequestParam ("searchType") String type){
        Map<String, Object> params = new HashMap<>();
        params.put("searchWord",word);
        params.put("searchType",type);
        return postsRepository.searchPostBywordWithCondition(params);
    }
     */
}
