package com.hyhr.hr_proj.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.blacklist.Blacklist;


@Getter
@NoArgsConstructor
public class BlacklistSaveRequestDto {
    private String name;
    private String explanation;

    @Builder
    public BlacklistSaveRequestDto(String name, String explanation){
        this.name = name;
        this.explanation = explanation;
    }

    public Blacklist toEntity() {
        return Blacklist.builder()
                .name(name)
                .explanation(explanation)
                .build();
    }
}
