package com.hyhr.hr_proj.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.blacklist.Blacklist;

@Getter
@NoArgsConstructor
public class BlacklistSaveHashedRequestDto {
    private String hashedName;
    private String explanation;

    @Builder
    public BlacklistSaveHashedRequestDto(String hashedName, String explanation){
        this.hashedName = hashedName;
        this.explanation = explanation;
    }

    public Blacklist toEntity() {
        return Blacklist.builder()
                .name(hashedName)
                .explanation(explanation)
                .build();
    }
}

