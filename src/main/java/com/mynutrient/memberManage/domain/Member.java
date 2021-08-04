package com.mynutrient.memberManage.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Long getUserSeq() {
        return userSeq;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public Role getRole() {
        return role;
    }

    public Member update(String name, String picture){
        this.name = name;
        this.picture = picture;
        return this;
    }

    public static final class MemberBuilder {
        private Long userSeq;
        private String name;
        private String email;
        private String picture;
        private Role role;

        private MemberBuilder() {
        }

        public static MemberBuilder aMember() {
            return new MemberBuilder();
        }

        public MemberBuilder userSeq(Long userSeq) {
            this.userSeq = userSeq;
            return this;
        }

        public MemberBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder picture(String picture) {
            this.picture = picture;
            return this;
        }

        public MemberBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public Member build() {
            Member member = new Member();
            member.userSeq = this.userSeq;
            member.name = this.name;
            member.email = this.email;
            member.role = this.role;
            member.picture = this.picture;
            return member;
        }
    }
}
