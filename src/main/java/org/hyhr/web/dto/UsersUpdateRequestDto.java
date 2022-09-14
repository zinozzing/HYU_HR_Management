package org.hyhr.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String email;
    private String authority;
    private LocalDate signUpDate;

    @Builder
    public UsersUpdateRequestDto(String email, String authority, LocalDate signUpDate){
        this.email = email;
        this.authority = authority;
        this.signUpDate = signUpDate;
    }
}
