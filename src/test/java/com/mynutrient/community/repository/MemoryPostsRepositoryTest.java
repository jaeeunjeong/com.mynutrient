package com.mynutrient.community.repository;

import com.mynutrient.community.domain.Posts;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.sql.*;

@Transactional
public class MemoryPostsRepositoryTest {

    @Autowired
    public PostsRepository repository;

    @AfterEach
    void afterEach() {
        //repository.clearPostsStorage();
    }

    @Test
    public void savePost() throws Exception {
        Posts post = new Posts();
        post.setTitle("I WANT TELL YOU");
        post.setContent("EVERYTHING IS GANNA BE OKAY");
        post.setWriter("leo10");
//        post.setRegDate();
        post.setPostLevel(1);
        post.setUseYN(true);
        repository.savePost(post);
    }

    @Test
    void updatePost() {
        Posts post = new Posts();
        post.setTitle("I WANT TELL YOU");
        post.setContent("EVERYTHING IS GANNA BE OKAY");
        post.setWriter("leo10");
        post.setPostLevel(1);
        post.setUseYN(true);

        repository.savePost(post);

        post.setContent("EVERYTHING IS GANNA BE FINE");

        repository.updatePost(post);

    }

    @Test
    void deletePost() {
        Posts post = new Posts();
        post.setTitle("I WANT TELL YOU");
        post.setContent("EVERYTHING IS GANNA BE OKAY");
        post.setWriter("leo10");
        post.setPostLevel(1);
        post.setUseYN(true);

        repository.savePost(post);

        post.setUseYN(true);

        repository.updatePost(post);

        Assertions.assertThat(post.getUseYN()).isEqualTo(false);
    }

    @Test
    void readPost() {
        Posts post = new Posts();
        post.setTitle("I WANT TELL YOU");
        post.setContent("EVERYTHING IS GANNA BE OKAY");
        post.setWriter("leo10");
        post.setPostLevel(1);
        post.setUseYN(true);

        Posts result = repository.savePost(post);

        Posts findPost = repository.readPost(result.getPostSeq());

        Assertions.assertThat(result).isEqualTo(findPost);

    }
}