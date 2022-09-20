package com.hyhr.hr_proj;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@RestController
public class TestController {

	@GetMapping("/")
	public String test() {
		return "index.html";
	}

    @GetMapping("/api/hello")
    public String hello() {
        return new Date() + "\n";
    }
}