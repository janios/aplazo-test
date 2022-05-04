package com.cristian.aplazotest.models.dto;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class CreditDto {

  private Integer idCredit;
  private Double amount;
  private Integer term;
  private Double rate;
  private Date createTS;
  private List<PaymentDto> payments;
}
