package com.mynutrient.config.auth;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import com.mynutrient.config.auth.dto.OAuthAttributes;
import com.mynutrient.config.auth.dto.SessionUser;
import com.mynutrient.memberManage.domain.Member;
import com.mynutrient.memberManage.repository.MemberManageRepository;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{

    private final MemberManageRepository memberManageRepository;
    private final HttpSession httpSession;

    public CustomOauth2UserService(MemberManageRepository memberManageRepository, HttpSession httpSession) {
        this.memberManageRepository = memberManageRepository;
        this.httpSession = httpSession;
    }

    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes  = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);

        httpSession.setAttribute("member", new SessionUser(member));
        return new DefaultOAuth2User(Collections.singleton(new
                SimpleGrantedAuthority(member.getRoleKey())),attributes.getAttributes(),attributes.getNameAttributeKey());
    }
    private Member saveOrUpdate(OAuthAttributes attributes) {
        Member member = memberManageRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update( attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return memberManageRepository.save(member);
    }
}