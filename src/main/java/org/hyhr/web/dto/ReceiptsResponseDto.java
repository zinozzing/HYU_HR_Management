package org.hyhr.web.dto;

import lombok.Getter;
import org.hyhr.domain.receipts.Receipts;

@Getter
public class ReceiptsResponseDto {
    private Long id;
    private String title;
    private String uploader;

    public ReceiptsResponseDto(Receipts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.uploader = entity.getUploader();
    }
}
