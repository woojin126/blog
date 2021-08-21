package myProject.blog.service;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.RequestDto;
import myProject.blog.entity.User;
import myProject.blog.exception.DuplicatedUsernameException;
import myProject.blog.exception.UserNotFoundException;
import myProject.blog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.TextUtils;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(RequestDto requestDto) throws Exception {
        if ((requestDto.getUsername() == null) || (requestDto.getUsername().equals("")) || (requestDto.getPassword().equals("")) || (requestDto.getPassword() == null)) {
            throw new UserNotFoundException("아이디 비밀번호는 공백 불가능");
        }

        Optional<User> user = userRepository.findUserByUsername(requestDto.toEntity().getUsername());
        if (user.isPresent()) {
            throw new DuplicatedUsernameException("이미 가입한 회원입니다");
        }
        return userRepository.save(requestDto.toEntity());
    }
}
