package myProject.blog.exception;

import lombok.extern.slf4j.Slf4j;
import myProject.blog.exception.customException.UserNotFoundException;
import myProject.blog.exception.customException.CustomErrorResponse;
import myProject.blog.exception.customException.DuplicatedUsernameException;
import myProject.blog.exception.validexception.ValidErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ValidErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ValidErrorResponse response = ValidErrorResponse.of(httpStatus.value(),LocalDateTime.now(), e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ValidErrorResponse> handleBindException(BindException e) {
        log.error("handleBindExceptions={}", e.getFieldErrors());
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ValidErrorResponse response = ValidErrorResponse.of(httpStatus.value(), LocalDateTime.now(), e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> processError(Exception e) {
        CustomErrorResponse response = new CustomErrorResponse();
        HttpStatus status = null;

        if (e instanceof DuplicatedUsernameException) {
            status = HttpStatus.BAD_REQUEST;
            response.setStatusCode(status.value());
            response.setMessage(e.getMessage());
        } else if (e instanceof UserNotFoundException) {
            status = HttpStatus.BAD_REQUEST;
            response.setStatusCode(status.value());
            response.setMessage(e.getMessage());
        } else {
            status = HttpStatus.NOT_FOUND;
            response.setStatusCode(status.value());
            response.setMessage(e.getMessage());
        }
        response.setCreateErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(response, status);
    }



}
