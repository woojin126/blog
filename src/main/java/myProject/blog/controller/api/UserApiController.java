package myProject.blog.controller.api;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.user.RequestDto;
import myProject.blog.dto.user.ResponseDto;
import myProject.blog.entity.enums.RoleInfo;
import myProject.blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor

public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<?> save(@Valid @RequestBody RequestDto requestDto, BindingResult result) throws Exception {
        failResponse(result);
        return new ResponseDto<>(userService.save(requestDto), HttpStatus.OK);
    }


    private void failResponse(BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
    }
}
