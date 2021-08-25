package myProject.blog.dto.user;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto<T> {

     T data;
     HttpStatus status;

     public ResponseDto(T data) {
          this.data = data;
     }

     public ResponseDto(T data, HttpStatus status) {
          this.data = data;
          this.status = status;
     }
}
