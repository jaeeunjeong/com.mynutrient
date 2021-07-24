package com.mynutrient.community.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postSeq;
    String title;
    String content;
    String writer;
    Date regDate;
    int postLevel;
    boolean useYN;

    public Long getPostSeq() {
        return postSeq;
    }

    public void setPostSeq(Long postSeq) {
        this.postSeq = postSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(int postLevel) {
        this.postLevel = postLevel;
    }

    public boolean isUseYN() {
        return useYN;
    }

    public void setUseYN(boolean useYN) {
        this.useYN = useYN;
    }
}
