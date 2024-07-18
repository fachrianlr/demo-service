package com.rian.common.exception;

import com.rian.common.dto.template.GenericResponse;
import com.rian.common.exception.exeptionlist.ClientException;
import com.rian.common.exception.exeptionlist.ServerException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<GenericResponse<Object>> handleAllExceptions(Exception ex) {

    String errMessage = "Mohon Maaf Sistem Bermasalah";
    GenericResponse<Object> errorMessage = GenericResponse.builder()
        .respCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
        .respDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
        .data(errMessage).build();

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    log.error(sw.toString());
    return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ServerException.class)
  public ResponseEntity<GenericResponse<Object>> serverException(ServerException ex) {
    GenericResponse<Object> errorMessage = GenericResponse.builder()
        .respCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
        .respDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
        .data(ex.getMessage()).build();
    return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ClientException.class)
  public ResponseEntity<GenericResponse<Object>> clientException(ClientException ex) {
    GenericResponse<Object> errorMessage = GenericResponse.builder()
        .respCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
        .respDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
        .data(Collections.singletonList(ex.getMessage()))
        .build();
    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
  }

}
