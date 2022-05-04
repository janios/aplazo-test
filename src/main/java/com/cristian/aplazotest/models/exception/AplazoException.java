package com.cristian.aplazotest.models.exception;

public class AplazoException extends Exception {

  private AplazoErrorMessage aplazoErrorMessage;

  public AplazoException(String message, int httpStatus) {
    super(message);
    this.aplazoErrorMessage =
        AplazoErrorMessage.builder().message(message).httpStatus(httpStatus).build();
  }
}
