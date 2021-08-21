package myProject.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.blog.entity.User;
import myProject.blog.entity.enums.RoleInfo;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDto {

    @NotBlank
    private String username;
    @NotBlank
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")
    private String password;
    private RoleInfo role;


    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .role(role)
                .build();
    }
}
