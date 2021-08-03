package com.mynutrient.config.auth.dto;

import java.io.Serializable;

import com.mynutrient.memberManage.domain.Member;

public class SessionUser implements Serializable{
    private String name;
    private String email;
    private String picture;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }
}