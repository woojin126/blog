package myProject.blog.controller;

import lombok.RequiredArgsConstructor;
import myProject.blog.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){

        return "user/loginForm";
    }




}
