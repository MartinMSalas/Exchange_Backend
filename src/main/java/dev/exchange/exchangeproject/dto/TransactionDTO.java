package dev.exchange.exchangeproject.dto;

import dev.exchange.exchangeproject.models.enums.TransactionStatus;
import dev.exchange.exchangeproject.models.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private String transactionId;
    private LocalDateTime dateAndTime;
    private TransactionType type;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    private String description;

    @NotNull(message = "Source Account ID cannot be null")
    private String sourceAccountId;

    @NotNull(message = "Destination Account ID cannot be null")
    private String destinationAccountId;

    private TransactionStatus status;
}
