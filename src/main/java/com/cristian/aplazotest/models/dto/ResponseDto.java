package com.cristian.aplazotest.models.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class ResponseDto {
  private Integer paymentNumber;
  private Double amount;
  private LocalDate paymentDate;
}
