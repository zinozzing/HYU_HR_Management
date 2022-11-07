package com.hyhr.hr_proj.domain.receipts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.hyhr.hr_proj.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Receipts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String uploader;

    @Column(nullable = false)
    private String url;

    @Builder
    public Receipts(String title, String uploader, String url){
        this.title = title;
        this.uploader = uploader;
        this.url = url;
    }

    public void update(String title, String uploader, String url){
        this.title = title;
        this.uploader = uploader;
        this.url = url;
    }

    // TODO 분류(개파, 엠티 등 카테고리)
    // TODO 여러 파일 업로드 기능
}
