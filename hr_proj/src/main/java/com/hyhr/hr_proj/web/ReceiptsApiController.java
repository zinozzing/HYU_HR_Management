package com.hyhr.hr_proj.web;

import lombok.RequiredArgsConstructor;
import com.hyhr.hr_proj.domain.service.receipts.ReceiptsService;
import com.hyhr.hr_proj.web.dto.ReceiptsResponseDto;
import com.hyhr.hr_proj.web.dto.ReceiptsSaveRequestDto;
import com.hyhr.hr_proj.web.dto.ReceiptsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReceiptsApiController {
    private final ReceiptsService receiptsService;

    @GetMapping("/api/v1/receipts/{id}")
    public ReceiptsResponseDto findById(@PathVariable Long id){
        return receiptsService.findById(id);
    }

    @PostMapping("/api/v1/receipt-save")
    public Long save(@RequestBody ReceiptsSaveRequestDto requestDto){
        return receiptsService.save(requestDto);
    }
    // TODO api for the list of receipts
//    public Long saveAll(@RequestBody List<ReceiptsSaveRequestDto> requestDtos){
//        return receiptsService.saveAll(requestDtos);

//    }

    @PutMapping("/api/v1/receipts/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReceiptsUpdateRequestDto requestDto){
        return receiptsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/receipts/{id}")
    public void delete(@PathVariable Long id){
        receiptsService.delete(id);
    }
}