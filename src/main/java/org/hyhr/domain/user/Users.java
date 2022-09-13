package org.hyhr.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO I think it should be indexed.
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String authority;

    @Column(nullable = false)
    private LocalDate signUpDate;

    @Builder
    public Users(String email, String authority, LocalDate signUpDate){
        this.email = email;
        this.authority = authority;
        this.signUpDate = signUpDate;
    }
}
