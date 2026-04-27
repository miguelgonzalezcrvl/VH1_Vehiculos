package cl.duoc.La.ReinaBMW.exception;

import cl.duoc.La.ReinaBMW.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleError(RuntimeException ex) {

        return ResponseEntity.badRequest()
                .body(new ApiResponse<>(400, ex.getMessage(), null));
    }
}
