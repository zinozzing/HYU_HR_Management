package org.hyhr.web.dto;

import lombok.Getter;
import org.hyhr.domain.users.Role;
import org.hyhr.domain.users.Users;

import java.time.LocalDate;

@Getter
public class UsersResponseDto {
    private Long id;
    private String email;
    private LocalDate signUpDate;
    private Role role;

    public UsersResponseDto(Users entity){
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.signUpDate = entity.getSignUpDate();
        this.role = entity.getRole();
    }
}
