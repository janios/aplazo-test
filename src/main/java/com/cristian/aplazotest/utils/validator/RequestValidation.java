package com.cristian.aplazotest.utils.validator;

import com.cristian.aplazotest.constants.AplazoConstants;
import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.exception.AplazoException;
import java.util.Objects;
import org.springframework.http.HttpStatus;

public class RequestValidation {

  public static void validateRequest(RequestDto request) throws AplazoException {
    validateNullAndPositive(request.getAmount(), AplazoConstants.INVALID_AMOUNT);
    validateNullAndPositive(request.getTerm(), AplazoConstants.INVALID_TERM);
    validateNullAndPositive(request.getRate(), AplazoConstants.INVALID_RATE);
  }

  private static void validateNullAndPositive(Number value, String message) throws AplazoException {

    if (Objects.isNull(value) || value.doubleValue() <= 0) {
      throw new AplazoException(message, HttpStatus.BAD_REQUEST.value());
    }
  }
}
