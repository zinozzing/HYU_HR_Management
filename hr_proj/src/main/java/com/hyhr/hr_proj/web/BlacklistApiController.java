package com.hyhr.hr_proj.web;

import lombok.RequiredArgsConstructor;
import com.hyhr.hr_proj.domain.service.blacklist.BlacklistService;
import com.hyhr.hr_proj.web.dto.BlacklistResponseDto;
import com.hyhr.hr_proj.web.dto.BlacklistSaveHashedRequestDto;
import com.hyhr.hr_proj.web.dto.BlacklistSaveRequestDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@RestController
public class BlacklistApiController {
    private final BlacklistService blacklistService;

    @GetMapping("/api/v1/blacklist/{name}")
    public BlacklistResponseDto findByName(@PathVariable String name) throws NoSuchAlgorithmException{
        String hashedName = sha256(name);
        return blacklistService.findById(hashedName);
    }


    @PostMapping("/api/v1/blacklist-save")
    public Long save(@RequestBody BlacklistSaveRequestDto requestDto) throws NoSuchAlgorithmException {
        BlacklistSaveHashedRequestDto blacklistSaveHashedRequestDto = BlacklistSaveHashedRequestDto.builder()
                .hashedName(sha256(requestDto.getName()))
                .explanation(requestDto.getExplanation())
                .build();
        return blacklistService.save(blacklistSaveHashedRequestDto);
    }

    /*
     * SHA-256으로 해싱하는 메소드
     *
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String sha256(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());

        return String.format("%040x", new BigInteger(1, md.digest()));
    }
}
