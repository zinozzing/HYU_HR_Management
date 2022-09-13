package org.hyhr.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO I think it should be indexed.
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int authority;

    @Column(nullable = false)
    private LocalDateTime signUpDate;
}
