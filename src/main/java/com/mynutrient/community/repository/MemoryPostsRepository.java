package com.mynutrient.community.repository;

import com.mynutrient.community.domain.Posts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryPostsRepository implements PostsRepository {

    private final EntityManager em;

    public MemoryPostsRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Posts savePost(Posts post) {
        em.persist(post);
        //저장한 후 seqId를 가져와야함.
        Posts newPost = em.find(Posts.class, post.getPostSeq());
        return newPost;
    }

    @Override
    public long updatePost(Posts post) {
        //update
        return 0;
    }

    @Override
    public long deletePost(int postSeq) {
        //update query
        return 0;
    }

    @Override
    public List<Posts> selectPostsList() {
        return em.createQuery("select p from Posts p", Posts.class).getResultList();
    }

    @Override
    public Posts readPost(int postSeq) {
        return em.find(Posts.class, postSeq);
    }
    /*
    @Override
    public List<Posts> searchPostBywordWithCondition(Map<String, Object> params) {
        String word = String.valueOf(params.get("searchWord"));
        String condition = String.valueOf(params.get("searchType"));
        List<Posts> result = em.createQuery("select p from Posts p" +
                "where p.word like :word" +
                "and p. = : condition", Posts.class)
                .setParameter("word", word)
                .setParameter("condition", condition)
                .getResultList();
        return result;
    }
     */
}
