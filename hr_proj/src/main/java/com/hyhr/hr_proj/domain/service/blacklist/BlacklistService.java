package com.hyhr.hr_proj.domain.service.blacklist;

import lombok.RequiredArgsConstructor;
import com.hyhr.hr_proj.domain.blacklist.BlacklistRepository;
import com.hyhr.hr_proj.domain.blacklist.Blacklist;
import com.hyhr.hr_proj.web.dto.BlacklistSaveHashedRequestDto;
import com.hyhr.hr_proj.web.dto.BlacklistResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BlacklistService {
    private final BlacklistRepository blacklistRepository;

    @Transactional
    public Long save(BlacklistSaveHashedRequestDto requestDto){
        return blacklistRepository.save(requestDto.toEntity()).getId();
    }

    public BlacklistResponseDto findById(String hashedName){
        Blacklist entity = blacklistRepository.findByName(hashedName).orElseThrow(() -> new IllegalArgumentException("There is no banned user."));
//        return blacklistRepository.findByName(hashedName);
        return new BlacklistResponseDto(entity);
    }
}
