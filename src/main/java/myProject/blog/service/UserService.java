package myProject.blog.service;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.user.RequestDto;
import myProject.blog.dto.user.RequestLoginDto;
import myProject.blog.entity.User;
import myProject.blog.entity.enums.RoleInfo;
import myProject.blog.exception.customException.DuplicatedUsernameException;
import myProject.blog.exception.customException.UserNotFoundException;
import myProject.blog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public User save(RequestDto requestDto) throws Exception {
        String rawPassword = requestDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        requestDto.setPassword(encPassword);
        requestDto.setRole(RoleInfo.ROLE_USER);

        Optional<User> user = userRepository.findUserByUsername(requestDto.toEntity().getUsername());

        if (user.isPresent()) {
            throw new DuplicatedUsernameException("이미 가입한 회원입니다");
        }
        return userRepository.save(requestDto.toEntity());
    }

   /* public User login(RequestLoginDto requestDto) throws Exception {
        return userRepository.findByUsernameAndPassword(requestDto.toEntity().getUsername(), requestDto.toEntity().getPassword()).orElseThrow(() -> {
            throw new UserNotFoundException("잘못된 아이디 비밀번호 입니다");
        });
    }*/
}
