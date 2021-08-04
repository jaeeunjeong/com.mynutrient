package com.mynutrient.config.auth.dto;

import com.mynutrient.memberManage.domain.Member;
import com.mynutrient.memberManage.domain.Role;

import java.util.Map;

public final class OAuthAttributesBuilder {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    private OAuthAttributesBuilder() {
    }

    public static OAuthAttributesBuilder anOAuthAttributes() {
        return new OAuthAttributesBuilder();
    }

    public OAuthAttributesBuilder attributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }

    public OAuthAttributesBuilder nameAttributeKey(String nameAttributeKey) {
        this.nameAttributeKey = nameAttributeKey;
        return this;
    }

    public OAuthAttributesBuilder name(String name) {
        this.name = name;
        return this;
    }

    public OAuthAttributesBuilder email(String email) {
        this.email = email;
        return this;
    }

    public OAuthAttributesBuilder picture(String picture) {
        this.picture = picture;
        return this;
    }

    public OAuthAttributes build() {
        OAuthAttributes oAuthAttributes = new OAuthAttributes();
        oAuthAttributes.picture = this.picture;
        oAuthAttributes.email = this.email;
        oAuthAttributes.attributes = this.attributes;
        oAuthAttributes.nameAttributeKey = this.nameAttributeKey;
        oAuthAttributes.name = this.name;
        return oAuthAttributes;
    }


    public Member toEntity() {
        return Member.MemberBuilder.aMember().name(name).email(email).picture(picture).role(Role.GUEST).build();
    }
}