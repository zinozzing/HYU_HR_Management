package org.hyhr.web.dto;

import lombok.Getter;
import org.hyhr.domain.users.Users;

import java.time.LocalDate;

@Getter
public class UsersResponseDto {
    private Long id;
    private String email;
    private String authority;
    private LocalDate signUpDate;

    public UsersResponseDto(Users entity){
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.authority = entity.getAuthority();
        this.signUpDate = entity.getSignUpDate();
    }
}
