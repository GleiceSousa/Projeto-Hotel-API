package com.trabalho.crud.core.entity;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class BusinessException extends RuntimeException {

  @Getter
  private HttpStatus status;

  public BusinessException() {
  }

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusinessException(Throwable cause) {
    super(cause);
  }

  public BusinessException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public static BusinessException notFoundException(String message) {
    return new BusinessException(message, HttpStatus.NOT_FOUND);
  }

}
