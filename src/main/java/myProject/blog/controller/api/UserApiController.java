package myProject.blog.controller.api;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.RequestDto;
import myProject.blog.dto.ResponseDto;
import myProject.blog.entity.enums.RoleInfo;
import myProject.blog.exception.GlobalControllerAdvice;
import myProject.blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;


    @PostMapping("/api/user/join")
    public ResponseDto<?> save(@Valid @RequestBody RequestDto requestDto) throws Exception {
        requestDto.setRole(RoleInfo.user);
        try {
            return new ResponseDto<>(userService.save(requestDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseDto<>(userService.save(requestDto));
        }

    }
}
