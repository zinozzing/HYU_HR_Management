package org.hyhr.domain.service.blacklist;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.blacklist.Blacklist;
import org.hyhr.domain.blacklist.BlacklistRepository;
import org.hyhr.web.dto.BlacklistResponseDto;
import org.hyhr.web.dto.BlacklistSaveHashedRequestDto;
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
