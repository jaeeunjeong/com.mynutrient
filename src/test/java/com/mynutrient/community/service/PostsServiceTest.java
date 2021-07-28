package com.mynutrient.community.service;

import com.mynutrient.community.domain.Posts;
import com.mynutrient.community.repository.MemoryPostsRepository;
import com.mynutrient.community.repository.PostsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PostsServiceTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    void save(Posts post) {
        postsRepository.savePost(post);
    }

    @Test
    void update(Posts post) {
        postsRepository.updatePost(post);
    }

    @Test
    Posts readPost(int currentPost) {
        return postsRepository.readPost(currentPost);
    }

    @Test
    Long deletePost(Posts post) {
        return postsRepository.deletePost(post.getPostSeq());
    }

    @Test
    List<Posts> selectPostsList() {
        return postsRepository.selectPostsList();
    }

}