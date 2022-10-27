package com.ms.ps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "payment_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private UUID id;
    private UUID orderId;
    private double amount;
    private String paymentStatus;
}
