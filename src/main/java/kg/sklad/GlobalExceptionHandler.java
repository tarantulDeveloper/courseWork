package kg.sklad;

import kg.sklad.exceptions.ResourceNotFoundException;
import kg.sklad.models.MyError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MyError> catchResourceNotFound(ResourceNotFoundException e) {
        log.error(e.getMessage(),e);
        return new ResponseEntity<>(
                new MyError(HttpStatus.NOT_FOUND.value(),e.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
