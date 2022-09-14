package org.hyhr.web;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.service.receipts.ReceiptsService;
import org.hyhr.web.dto.ReceiptsResponseDto;
import org.hyhr.web.dto.ReceiptsSaveRequestDto;
import org.hyhr.web.dto.ReceiptsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReceiptsApiController {
    private final ReceiptsService receiptsService;

    @PostMapping("/api/v1/receipt-save")
    public Long save(@RequestBody ReceiptsSaveRequestDto requestDto){
        return receiptsService.save(requestDto);
    }

    // TODO api for the list of receipts
//    public Long saveAll(@RequestBody List<ReceiptsSaveRequestDto> requestDtos){
//        return receiptsService.saveAll(requestDtos);
//    }

    @GetMapping("/api/v1/receipts/{id}")
    public ReceiptsResponseDto findById(@PathVariable Long id){
        return receiptsService.findById(id);
    }
    @PutMapping("/api/v1/receipts/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReceiptsUpdateRequestDto requestDto){
        return receiptsService.update(id, requestDto);
    }
}
