package com.hyhr.hr_proj.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO I think it should be indexed.
    @Column(nullable = false)
    private String email;

    // TODO authority 부분 role 수정 후 지우기
    // authority: DEVELOPER(all), MANAGER(management), MEMBER(watch)
//    @Column(nullable = false)
//    private String authority;

    @Column(nullable = false)
    private LocalDate signUpDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Users(String email, LocalDate signUpDate, Role role){
        this.email = email;
        this.signUpDate = signUpDate;
        this.role = role;
    }

    public void update(String email, LocalDate signUpDate, Role role){
        this.email = email;
        this.signUpDate = signUpDate;
        this.role = role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
