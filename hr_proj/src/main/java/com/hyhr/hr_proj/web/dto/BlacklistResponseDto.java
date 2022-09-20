package com.hyhr.hr_proj.web.dto;

import lombok.Getter;
import com.hyhr.hr_proj.domain.blacklist.Blacklist;

@Getter
public class BlacklistResponseDto {
    String explanation;

    public BlacklistResponseDto(Blacklist entity){
        this.explanation = entity.getExplanation();
    }
}
