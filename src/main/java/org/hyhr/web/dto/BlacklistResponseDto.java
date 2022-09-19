package org.hyhr.web.dto;

import lombok.Getter;
import org.hyhr.domain.blacklist.Blacklist;

@Getter
public class BlacklistResponseDto {
    String explanation;

    public BlacklistResponseDto(Blacklist entity){
        this.explanation = entity.getExplanation();
    }
}
