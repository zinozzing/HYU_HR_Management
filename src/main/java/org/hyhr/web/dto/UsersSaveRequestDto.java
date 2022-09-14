package org.hyhr.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hyhr.domain.users.Users;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String email;

    private String authority;

    private LocalDate signUpDate;

    @Builder
    public UsersSaveRequestDto(String email, String authority, LocalDate signUpDate){
        this.email = email;
        this.authority = authority;
        this.signUpDate = signUpDate;
    }

    public Users toEntity(){
        return Users.builder()
                .email(email)
                .authority(authority)
                .signUpDate(signUpDate)
                .build();
    }
}
