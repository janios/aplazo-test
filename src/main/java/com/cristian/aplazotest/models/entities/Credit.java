package com.cristian.aplazotest.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "CREDIT")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Credit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCredit;

  @Column private Double amount;

  @Column private Integer term;

  @Column private Double rate;

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createTS;

  @OneToMany(mappedBy = "credit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Payment> payments;
}
