package com.cristian.aplazotest.models.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AplazoErrorMessage {

  private String message;
  private int httpStatus;
}
