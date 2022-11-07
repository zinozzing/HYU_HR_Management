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
    private String url;
    @Builder
    public ReceiptsSaveRequestDto(String title, String uploader, String url){
        this.title = title;
        this.uploader = uploader;
        this.url = url;
    }

    public Receipts toEntity() {
        return Receipts.builder()
                .title(title)
                .uploader(uploader)
                .url(url)
                .build();
    }
}
