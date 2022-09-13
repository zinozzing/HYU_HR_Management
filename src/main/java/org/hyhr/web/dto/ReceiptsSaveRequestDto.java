package org.hyhr.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hyhr.domain.receipts.Receipts;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
