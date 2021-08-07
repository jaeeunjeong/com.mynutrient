package com.mynutrient.community.service;

import com.mynutrient.community.domain.Posts;
import com.mynutrient.community.repository.MemoryPostsRepository;
import com.mynutrient.community.repository.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PostsServiceTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsService postsService;

    @Test
    void 포스트가_저장되는지_확인() throws Exception{
        Posts post = new Posts();
        post.setTitle("I WANT TELL YOU");
        post.setContent("EVERYTHING IS GANNA BE OKAY");
        post.setWriter("leo10");
//        post.setRegDate();
        post.setPostLevel(1);
        post.setUseYN(true);

        //when
        Posts result = postsRepository.savePost(post);

        //then
        Posts findPost = postsRepository.readPost(result.getPostSeq());

        Assertions.assertThat(result).isEqualTo(findPost);

    }
}