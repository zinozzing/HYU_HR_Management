package org.hyhr.web;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.service.users.UsersService;
import org.hyhr.web.dto.UsersResponseDto;
import org.hyhr.web.dto.UsersSaveRequestDto;
import org.hyhr.web.dto.UsersUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping("/api/v1/user-save")
    public Long save(@RequestBody UsersSaveRequestDto requestDto){
        return usersService.save(requestDto);
    }

    @GetMapping("/api/v1/users/{id}")
    public UsersResponseDto findById(@PathVariable Long id){
        return usersService.findById(id);
    }

    @PutMapping("/api/v1/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto){
        return usersService.update(id, requestDto);
    }
}
