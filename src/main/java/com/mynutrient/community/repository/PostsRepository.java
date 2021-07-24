package com.mynutrient.community.repository;

import com.mynutrient.community.domain.Posts;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PostsRepository {

    public Posts savePost(Posts post);

    public long updatePost(Posts post);

    public long deletePost(int postSeq);

    public List<Posts> selectPostsList();

    public Posts readPost(int postSeq);

    //public List<Posts> searchPostBywordWithCondition(Map<String, Object> params);

}
