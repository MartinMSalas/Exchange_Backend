package dev.exchange.exchangeproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String type;

    private BigDecimal amount;

    private String description;

    private String sourceAccountId;

    private String destinationAccountId;

    @Enumerated(EnumType.STRING)
    private Enum status;

}
