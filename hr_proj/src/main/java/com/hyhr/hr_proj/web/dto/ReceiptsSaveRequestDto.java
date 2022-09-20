package com.hyhr.hr_proj.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.receipts.Receipts;

@Getter
@NoArgsConstructor
public class ReceiptsSaveRequestDto {
    private String title;
    private String uploader;
    @Builder
    public ReceiptsSaveRequestDto(String title, String uploader){
        this.title = title;
        this.uploader = uploader;
    }

    public Receipts toEntity() {
        return Receipts.builder()
                .title(title)
                .uploader(uploader)
                .build();
    }
}
