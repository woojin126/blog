package myProject.blog.dto.board;

import lombok.*;
import myProject.blog.entity.Board;
import myProject.blog.entity.User;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestBoardDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private int count;
    private User user;

    @Builder
    public RequestBoardDto(@NotBlank String title, @NotBlank String content, int count, User user) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.user = user;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .count(count)
                .user(user)
                .build();
    }
}
