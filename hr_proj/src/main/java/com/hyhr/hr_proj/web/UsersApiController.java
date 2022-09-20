package com.hyhr.hr_proj.web;

import lombok.RequiredArgsConstructor;
import com.hyhr.hr_proj.domain.service.users.UsersService;
import com.hyhr.hr_proj.web.dto.UsersResponseDto;
import com.hyhr.hr_proj.web.dto.UsersSaveRequestDto;
import com.hyhr.hr_proj.web.dto.UsersUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UsersApiController {
    private final UsersService usersService;

    @GetMapping("/api/v1/users/{id}")
    public UsersResponseDto findById(@PathVariable Long id){
        return usersService.findById(id);
    }

    @PostMapping("/api/v1/user-save")
    public Long save(@RequestBody UsersSaveRequestDto requestDto){
        return usersService.save(requestDto);
    }

    @PutMapping("/api/v1/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto){
        return usersService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public void delete(@PathVariable Long id){
        usersService.delete(id);
    }
}
