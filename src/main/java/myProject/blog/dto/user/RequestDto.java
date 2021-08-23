package myProject.blog.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.blog.entity.User;
import myProject.blog.entity.enums.RoleInfo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDto {

    @NotBlank(message = "이름은 필수 입력값 입니다")
    private String username;
    @NotBlank(message = "비밀번호는 대소문자,특수문자,8자이상")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")
    private String password;

    @Email(message = "이메일의 정확한 형식을 지켜주세요")
    @NotBlank
    private String email;
    private RoleInfo role;


    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .build();
    }
}
