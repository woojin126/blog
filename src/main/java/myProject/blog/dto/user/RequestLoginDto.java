package myProject.blog.dto.user;

import lombok.*;
import myProject.blog.entity.User;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestLoginDto {

    @NotBlank(message = "공백은 안됩니다")
    private String username;
    @NotBlank(message = "공백은 안됩니다")
    private String password;


    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
