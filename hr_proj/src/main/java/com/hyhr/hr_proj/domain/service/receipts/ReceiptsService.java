package com.hyhr.hr_proj.domain.service.receipts;

import lombok.RequiredArgsConstructor;
import com.hyhr.hr_proj.domain.receipts.Receipts;
import com.hyhr.hr_proj.domain.receipts.ReceiptsRepository;
import com.hyhr.hr_proj.web.dto.ReceiptsResponseDto;
import com.hyhr.hr_proj.web.dto.ReceiptsSaveRequestDto;
import com.hyhr.hr_proj.web.dto.ReceiptsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReceiptsService {
    private final ReceiptsRepository receiptsRepository;

    @Transactional
    public Long save(ReceiptsSaveRequestDto requestDto){
        return receiptsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReceiptsUpdateRequestDto requestDto){
        Receipts receipts = receiptsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no receipt. id=" + id));
        receipts.update(requestDto.getTitle(), requestDto.getUploader(), requestDto.getUrl());

        return id;
    }
    @Transactional
    public void delete(Long id){
        // check for existence first.
        receiptsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no receipt. id=" + id));
        // then delete.
        receiptsRepository.deleteById(id);
    }

    public ReceiptsResponseDto findById(Long id){
        Receipts entity = receiptsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no receipt. id=" + id));

        return new ReceiptsResponseDto(entity);
    }
}
