package com.hyhr.hr_proj.config.auth.dto;

import lombok.Getter;
import com.hyhr.hr_proj.domain.users.Users;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String email;

    public SessionUser(Users user){
        this.email = user.getEmail();
    }
}
