package org.hyhr.web;

import lombok.RequiredArgsConstructor;
import org.hyhr.config.auth.LoginUser;
import org.hyhr.config.auth.dto.SessionUser;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController implements ErrorController {
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("user", user.getEmail());
        }

        return "index.html";
    }
}
