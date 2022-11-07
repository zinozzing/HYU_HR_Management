package com.hyhr.hr_proj.web;

import com.hyhr.hr_proj.domain.AwsS3.AwsS3Repository;
import lombok.RequiredArgsConstructor;
import com.hyhr.hr_proj.domain.service.receipts.ReceiptsService;
import com.hyhr.hr_proj.web.dto.ReceiptsResponseDto;
import com.hyhr.hr_proj.web.dto.ReceiptsSaveRequestDto;
import com.hyhr.hr_proj.web.dto.ReceiptsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ReceiptsApiController {
    private final ReceiptsService receiptsService;
    private final AwsS3Repository awsS3Repository;

    @GetMapping("/api/v1/receipts/{id}")
    public ReceiptsResponseDto findById(@PathVariable Long id){
        return receiptsService.findById(id);
    }

//    @PostMapping("/api/v1/receipt-save")
//    public Long save(@RequestBody ReceiptsSaveRequestDto requestDto){
//        return receiptsService.save(requestDto);
//    }

    @PostMapping("/api/v1/receipts-save")
    public Long save(@RequestParam("title") String title, @RequestParam("uploader") String uploader, @RequestParam("file")MultipartFile file) throws IOException {
        String url = awsS3Repository.upload(file, "receipts");
        ReceiptsSaveRequestDto requestDto = new ReceiptsSaveRequestDto(title, uploader, url);

        return receiptsService.save(requestDto);
    }


    @PutMapping("/api/v1/receipts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody ReceiptsUpdateRequestDto requestDto) throws IOException{
    public Long update(@PathVariable Long id, @RequestParam("title") String title, @RequestParam("uploader") String uploader, @RequestParam("file")MultipartFile file) throws IOException{
        String url = awsS3Repository.upload(file, "receipts");
        ReceiptsUpdateRequestDto requestDto = new ReceiptsUpdateRequestDto(title, uploader, url);
        return receiptsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/receipts/{id}")
    public void delete(@PathVariable Long id){
        receiptsService.delete(id);
    }
}
