package com.cristian.aplazotest.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RequestDto {

  private Double amount;
  private Integer term;
  private Double rate;
}
