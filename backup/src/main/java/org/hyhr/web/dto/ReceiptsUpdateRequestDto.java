package org.hyhr.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReceiptsUpdateRequestDto {
    private String title;
    private String uploader;

    @Builder
    public ReceiptsUpdateRequestDto(String title, String uploader){
        this.title = title;
        this.uploader = uploader;
    }
}
