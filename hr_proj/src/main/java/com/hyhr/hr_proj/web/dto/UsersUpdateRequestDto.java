package com.hyhr.hr_proj.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.users.Role;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String email;
    private LocalDate signUpDate;
    private Role role;
    private String nickname;

    @Builder
    public UsersUpdateRequestDto(String email, LocalDate signUpDate, Role role, String nickname){
        this.email = email;
        this.signUpDate = signUpDate;
        this.role = role;
        this.nickname = nickname;
    }
}
