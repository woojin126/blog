package myProject.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.blog.entity.User;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@Builder
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
