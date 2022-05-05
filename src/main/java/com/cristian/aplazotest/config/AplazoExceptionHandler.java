package com.cristian.aplazotest.config;

import com.cristian.aplazotest.models.exception.AplazoErrorMessage;
import com.cristian.aplazotest.models.exception.AplazoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class AplazoExceptionHandler {

  @ExceptionHandler(value = AplazoException.class)
  private ResponseEntity<AplazoErrorMessage> handleException(Exception ex, WebRequest request) {
    log.error("Aplazo Exception {} ", ex);
    return new ResponseEntity<>(
        AplazoErrorMessage.builder()
            .message(ex.getMessage())
            .httpStatus(HttpStatus.BAD_REQUEST.value())
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = Exception.class)
  private ResponseEntity<AplazoErrorMessage> unhandledException(Exception ex, WebRequest request) {
    log.error("Aplazo Unhandled Exception {} ", ex);
    return new ResponseEntity<>(
        AplazoErrorMessage.builder()
            .message(ex.getMessage())
            .httpStatus(HttpStatus.BAD_REQUEST.value())
            .build(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
