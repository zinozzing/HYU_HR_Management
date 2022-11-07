package com.hyhr.hr_proj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

//@RestController
@Controller
public class WebController {

	@GetMapping("/")
	public String test() {
		return "index.html";
	}

    @GetMapping("/api/hello")
    @ResponseBody
    public String hello() {
        return new Date() + "\n";
    }
}