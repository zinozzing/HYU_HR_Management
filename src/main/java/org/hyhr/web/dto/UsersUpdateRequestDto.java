package org.hyhr.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hyhr.domain.users.Role;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String email;
    private LocalDate signUpDate;
    private Role role;

    @Builder
    public UsersUpdateRequestDto(String email, LocalDate signUpDate, Role role){
        this.email = email;
        this.signUpDate = signUpDate;
        this.role = role;
    }
}
