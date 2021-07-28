package com.mynutrient.community.repository;

import com.mynutrient.community.domain.Posts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MemoryPostsRepository implements PostsRepository {

    private final EntityManager em;

    public MemoryPostsRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Posts savePost(Posts post) {
        //최초 저장은 persist
        em.persist(post);
        //저장한 후 seqId를 가져와야함.
        Posts newPost = em.find(Posts.class, post.getPostSeq());
        return newPost;
    }

    @Override
    public long updatePost(Posts post) {
        //최초의 값이 아니라면 merge
        em.merge(post);
        return post.getPostSeq();
    }

    @Override
    public long deletePost(long postSeq) {
        Posts post = em.find(Posts.class, postSeq);
        post.setUseYN(false);
        em.merge(post);
        return postSeq;
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

    public void clearPostsStorage() {
         em.clear();
    }
}
