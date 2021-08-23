package myProject.blog.service;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.user.RequestDto;
import myProject.blog.dto.user.RequestLoginDto;
import myProject.blog.entity.User;
import myProject.blog.exception.customException.DuplicatedUsernameException;
import myProject.blog.exception.customException.UserNotFoundException;
import myProject.blog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(RequestDto requestDto) throws Exception {
        if ((requestDto.getUsername() == null) || (requestDto.getUsername().equals(""))
                || (requestDto.getPassword() == null) || (requestDto.getPassword().equals(""))
                || (requestDto.getEmail() == null) || (requestDto.getEmail().equals(""))) {
            throw new UserNotFoundException("아이디 비밀번호는 공백 불가능");
        }

        Optional<User> user = userRepository.findUserByUsername(requestDto.toEntity().getUsername());
        if (user.isPresent()) {
            throw new DuplicatedUsernameException("이미 가입한 회원입니다");
        }
        return userRepository.save(requestDto.toEntity());
    }

    public User login(RequestLoginDto requestDto) throws Exception {
        return userRepository.findByUsernameAndPassword(requestDto.toEntity().getUsername(), requestDto.toEntity().getPassword()).orElseThrow(() -> {
            throw new UserNotFoundException("잘못된 아이디 비밀번호 입니다");
        });
    }
}
