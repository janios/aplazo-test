package com.cristian.aplazotest.models.dto;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

@Data
public class PaymentDto {
  private Integer paymentNumber;
  private Double amount;
  private LocalDate paymentDate;
  private Date createTS;
}
