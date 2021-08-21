package myProject.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
/*https://www.python2.net/questions-904831.htm*/
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> processError(Exception e){
        CustomErrorResponse response = new CustomErrorResponse();
        HttpStatus status = null;

        if (e instanceof DuplicatedUsernameException)
        {
            status = HttpStatus.BAD_REQUEST;
            response.setStatusCode(status.value());
            response.setMessage(e.getMessage());
        }
        else if (e instanceof UserNotFoundException) {
            status = HttpStatus.BAD_REQUEST;
            response.setStatusCode(status.value());
            response.setMessage(e.getMessage());
        }
        else
        {
            status = HttpStatus.NOT_FOUND;
            response.setStatusCode(status.value());
            response.setMessage(e.getMessage());
        }
        response.setCreateErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(response, status);
    }
}
