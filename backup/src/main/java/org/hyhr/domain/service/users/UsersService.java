package org.hyhr.domain.service.users;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.users.Users;
import org.hyhr.domain.users.UsersRepository;
import org.hyhr.web.dto.UsersResponseDto;
import org.hyhr.web.dto.UsersSaveRequestDto;
import org.hyhr.web.dto.UsersUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto){
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UsersUpdateRequestDto requestDto){
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no user. id=" + id));
        users.update(requestDto.getEmail(), requestDto.getSignUpDate(), requestDto.getRole());

        return id;
    }
    @Transactional
    public void delete(Long id){
        // check for existence first.
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no user. id=" + id));
        // then delete.
        usersRepository.deleteById(id);
    }

    public UsersResponseDto findById(Long id){
        Users entity = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no user. id=" + id));

        return new UsersResponseDto(entity);
    }
}
