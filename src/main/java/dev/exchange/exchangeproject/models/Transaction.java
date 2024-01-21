package dev.exchange.exchangeproject.models;


import dev.exchange.exchangeproject.models.enums.TransactionType;
import dev.exchange.exchangeproject.models.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //private String id;
    private String transactionId;

    @Temporal(TemporalType.DATE)
    private LocalDateTime dateAndTime;

    //private String type;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;

    private String description;

    private String sourceAccountId;

    private String destinationAccountId;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

}
