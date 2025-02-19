package io.github.sebastiangb1.appfranquicias.exception;

import io.github.sebastiangb1.appfranquicias.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ApiResponse> handlerRecursoNoEncontradoException(RecursoNoEncontradoException ex){
        return ResponseEntity.badRequest().body(ApiResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .build());
    }
}
