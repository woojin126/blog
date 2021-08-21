package myProject.blog.controller;

import lombok.RequiredArgsConstructor;
import myProject.blog.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }

    @GetMapping("/user/loginForm")
    public String loginForm(){

        return "user/loginForm";
    }




}
