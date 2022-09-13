package org.hyhr.domain.service.receipts;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.receipts.ReceiptsRepository;
import org.hyhr.web.dto.ReceiptsSaveRequestDto;
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
}
