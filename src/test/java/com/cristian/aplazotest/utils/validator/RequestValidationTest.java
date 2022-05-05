package com.cristian.aplazotest.utils.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cristian.aplazotest.constants.AplazoConstants;
import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.exception.AplazoException;
import org.junit.jupiter.api.Test;

public class RequestValidationTest {

  @Test
  public void requestValidationTest() {
    AplazoException thrown =
        assertThrows(
            AplazoException.class,
            () -> {
              RequestValidation.validateRequest(RequestDto.builder().build());
            });
    assertEquals(thrown.getMessage(), AplazoConstants.INVALID_AMOUNT);
    thrown =
        assertThrows(
            AplazoException.class,
            () -> {
              RequestValidation.validateRequest(RequestDto.builder().amount(0d).build());
            });
    assertEquals(thrown.getMessage(), AplazoConstants.INVALID_AMOUNT);
    thrown =
        assertThrows(
            AplazoException.class,
            () -> {
              RequestValidation.validateRequest(RequestDto.builder().amount(1d).build());
            });
    assertEquals(thrown.getMessage(), AplazoConstants.INVALID_TERM);

    thrown =
        assertThrows(
            AplazoException.class,
            () -> {
              RequestValidation.validateRequest(RequestDto.builder().amount(1d).term(-5).build());
            });
    assertEquals(thrown.getMessage(), AplazoConstants.INVALID_TERM);

    thrown =
        assertThrows(
            AplazoException.class,
            () -> {
              RequestValidation.validateRequest(RequestDto.builder().amount(1d).term(1).build());
            });
    assertEquals(thrown.getMessage(), AplazoConstants.INVALID_RATE);

    thrown =
        assertThrows(
            AplazoException.class,
            () -> {
              RequestValidation.validateRequest(
                  RequestDto.builder().amount(1d).term(15).rate(0d).build());
            });
    assertEquals(thrown.getMessage(), AplazoConstants.INVALID_RATE);
  }
}
