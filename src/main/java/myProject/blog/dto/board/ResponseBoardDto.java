package myProject.blog.dto.board;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseBoardDto<T> {

    T data;
    HttpStatus status;

    public ResponseBoardDto(T data){
        this.data = data;
    }

    public ResponseBoardDto(T data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }
}
