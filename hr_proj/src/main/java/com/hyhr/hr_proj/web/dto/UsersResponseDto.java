package com.hyhr.hr_proj.web.dto;

import lombok.Getter;
import com.hyhr.hr_proj.domain.users.Role;
import com.hyhr.hr_proj.domain.users.Users;

import java.time.LocalDate;

@Getter
public class UsersResponseDto {
    private Long id;
    private String email;
    private LocalDate signUpDate;
    private Role role;

    private String nickname;

    public UsersResponseDto(Users entity){
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.signUpDate = entity.getSignUpDate();
        this.role = entity.getRole();
        this.nickname = entity.getNickname();
    }
}
