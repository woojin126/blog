package myProject.blog.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomErrorResponse {

    private int statusCode;
    private String message;
    private LocalDateTime createErrorTime;
}
