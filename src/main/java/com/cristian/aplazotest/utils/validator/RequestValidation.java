package com.cristian.aplazotest.utils.validator;

import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.exception.AplazoException;
import java.util.Objects;
import org.springframework.http.HttpStatus;

public class RequestValidation {

  public static void validateRequest(RequestDto request) throws AplazoException {
    // TODO CHANGE CONSTANTS
    validateNullAndPositive(request.getAmount(), "Amount is not valid");
    validateNullAndPositive(request.getTerm(), "Term is not valid");
    validateNullAndPositive(request.getRate(), "Rate is not valid");
  }

  private static void validateNullAndPositive(Number value, String message) throws AplazoException {
    if (Objects.isNull(value) || (Double) value > 0) {
      throw new AplazoException(message, HttpStatus.BAD_REQUEST.value());
    }
  }
}
