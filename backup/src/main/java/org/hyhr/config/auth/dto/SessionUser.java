package org.hyhr.config.auth.dto;

import lombok.Getter;
import org.hyhr.domain.users.Users;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String email;

    public SessionUser(Users user){
        this.email = user.getEmail();
    }
}
