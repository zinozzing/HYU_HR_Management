package org.hyhr.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hyhr.domain.users.Role;
import org.hyhr.domain.users.Users;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String email;
    private LocalDate signUpDate;
    private Role role;

    @Builder
    public UsersSaveRequestDto(String email, LocalDate signUpDate, Role role){
        this.email = email;
        this.signUpDate = signUpDate;
        this.role = role;
    }

    public Users toEntity(){
        return Users.builder()
                .email(email)
                .signUpDate(signUpDate)
                .role(role)
                .build();
    }
}
