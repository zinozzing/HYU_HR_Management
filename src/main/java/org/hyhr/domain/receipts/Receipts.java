package org.hyhr.domain.receipts;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Receipts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, nullable = false)
    private String title;

    @Column(length = 64, nullable = false)
    private String uploader;

    // TODO 분류(개파, 엠티 등 카테고리)
    // TODO 여러 파일 업로드 기능
}
