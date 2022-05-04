package com.cristian.aplazotest.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "PAYMENT")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPayment;

  @Column private Integer paymentNumber;

  @Column private Double amount;

  @Column private LocalDate paymentDate;

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  @Column
  private Date createTS;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "idCredit", nullable = false)
  @JsonBackReference
  private Credit credit;
}
