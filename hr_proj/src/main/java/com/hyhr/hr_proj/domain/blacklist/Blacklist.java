package com.hyhr.hr_proj.domain.blacklist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Blacklist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String explanation;

    @Builder
    public Blacklist(String name, String explanation){
        this.name = name;
        this.explanation = explanation;
    }
}
