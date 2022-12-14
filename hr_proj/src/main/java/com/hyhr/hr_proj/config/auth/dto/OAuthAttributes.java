package com.hyhr.hr_proj.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import com.hyhr.hr_proj.domain.users.Role;
import com.hyhr.hr_proj.domain.users.Users;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String email){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
//        if("naver".equals(registrationId)){
//
//            return ofNaver("id", attributes);
//        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

//    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
//        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
//
//        return OAuthAttributes.builder()
////                .name((String) response.get("name"))
//                .email((String) response.get("email"))
////                .picture((String) response.get("picture"))
//                .attributes(response)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }

    public Users toEntity(){
        return Users.builder()
                .email(email)
                .role(Role.GUEST)
                .build();
    }
}