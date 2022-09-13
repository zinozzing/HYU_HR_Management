package org.hyhr.web;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.service.receipts.ReceiptsService;
import org.hyhr.web.dto.ReceiptsSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReceiptsApiController {
    private final ReceiptsService receiptsService;

    @PostMapping("/api/v1/receipt-save")
    public Long save(@RequestBody ReceiptsSaveRequestDto requestDto){
        return receiptsService.save(requestDto);
    }
}
