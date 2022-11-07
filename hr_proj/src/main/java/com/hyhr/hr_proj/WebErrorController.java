package com.hyhr.hr_proj;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError() {
        return "index.html";
    }

    // getErrorPath() had been deprecated.
//    @Override
//    public String getErrorPath() {
//        return "error";
//    }
}
