package myProject.blog.controller.api;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.user.RequestDto;
import myProject.blog.dto.user.RequestLoginDto;
import myProject.blog.dto.user.ResponseDto;
import myProject.blog.entity.User;
import myProject.blog.entity.enums.RoleInfo;
import myProject.blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user/join")
    public ResponseDto<?> save(@Valid @RequestBody RequestDto requestDto, BindingResult result) throws Exception {
        failResponse(result);
        requestDto.setRole(RoleInfo.user);
        return new ResponseDto<>(userService.save(requestDto), HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseDto<?> login(@Valid @RequestBody RequestLoginDto requestDto, BindingResult result, HttpSession session) throws Exception {
        failResponse(result);

        User userLogin = userService.login(requestDto);
        session.setAttribute("principal", userLogin);

        return new ResponseDto<>(userLogin, HttpStatus.OK);

    }

    private void failResponse(BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
    }
}
